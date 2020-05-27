package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.CarFee;
import pl.parabar.deliveryregister01.entity.Refuel;
import pl.parabar.deliveryregister01.entity.Report;
import pl.parabar.deliveryregister01.entity.Route;
import pl.parabar.deliveryregister01.repository.CarFeeRepository;
import pl.parabar.deliveryregister01.repository.RouteRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.time.*;
import java.util.*;


@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private CarFeeRepository carFeeRepository;

    @Autowired
    private RouteRepository routeRepository;

    public String createDate() {
        return timeService.getDate();
    }

    @ModelAttribute("months")
    public List<Integer> months() {
        List<Integer> months = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            months.add(i);
        }
        return months;
    }

    @ModelAttribute("types")
    public List<String> types() {
        List<String> types = Arrays.asList(
                "miesiąc do miesiąca",
                "rok do roku",
                "miesiąc",
                "rok"
                );
        return types;
    }

    @ModelAttribute("years")
    public List<Integer> years() {
        Integer currentYear = LocalDate.now().getYear();
        List<Integer> years = new ArrayList<>();
        for (int i = 2018; i <= currentYear; i++) {
            years.add(i);
        }
        return years;
    }

    @GetMapping("/form")
    public String getParameters(Model model) {
        model.addAttribute("report", new Report());
        return "report/report-form";
    }

    @PostMapping("/form")
    public String addCarFeeProceed(@ModelAttribute @Valid Report report,
                                   BindingResult result,
                                   Model model) {

        int year1 = 0;
        int year2 = 0;
        int month1 = 0;
        int month2 = 0;

        if (report.getYears().size() == 0) {
            model.addAttribute("error", "Brak wskazanego roku");
        } else if (report.getYears().size() == 1) {
            year1 += report.getYears().get(0);
        } else if (report.getYears().size() == 2) {
            year2 += report.getYears().get(1);
        }

        if (report.getMonths().size() == 0) {
            model.addAttribute("error", "Brak wskazanego miesiąca");
        } else if (report.getMonths().size() == 1) {
            month1 += report.getMonths().get(0);
        } else if (report.getMonths().size() == 2) {
            month2 += report.getMonths().get(1);
        }

        List<CarFee> fees = new ArrayList<>();
        List<Route> routes = new ArrayList<>();
        double feesTotal1 = 0;
        double income1 = 0;
        double feesTotal2 = 0;
        double income2 = 0;

        if (report.getType().equals("miesiąc")) {

            String monthDayFirst = String.valueOf(YearMonth.of(year1, month1).atDay(1));
            String monthDayLast = String.valueOf(YearMonth.of(year1, month1).atEndOfMonth());
            fees = carFeeRepository.findAllByDateBetween(monthDayFirst, monthDayLast);
            routes = routeRepository.findAllByDateBetween(monthDayFirst, monthDayLast);

            feesTotal1 = getFeesTotal(fees);
            income1 = getIncome(routes);

            model.addAttribute("feesList1", fees);
            model.addAttribute("type", 1);

        } else if (report.getType().equals("rok")) {

            fees = carFeeRepository.findAllByDateContaining(year1);
            routes = routeRepository.findAllByDateContaining(year1);

            feesTotal1 = getFeesTotal(fees);
            income1 = getIncome(routes);

            model.addAttribute("feesList1", fees);
            model.addAttribute("type", 1);

        } else if (report.getType().equals("miesiąc do miesiąca")) {

            String year1MonthDayFirst = String.valueOf(YearMonth.of(year1, month1).atDay(1));
            String year1MonthDayLast = String.valueOf(YearMonth.of(year1, month1).atEndOfMonth());
            String year2MonthDayFirst = String.valueOf(YearMonth.of(year2, month1).atDay(1));
            String year2MonthDayLast = String.valueOf(YearMonth.of(year2, month1).atEndOfMonth());

            List<CarFee> feesFromYear1 = carFeeRepository.findAllByDateBetween(year1MonthDayFirst, year1MonthDayLast);
            List<CarFee> feesFromYear2 = carFeeRepository.findAllByDateBetween(year2MonthDayFirst, year2MonthDayLast);
            List<Route> routesFromYear1 = routeRepository.findAllByDateBetween(year1MonthDayFirst, year1MonthDayLast);
            List<Route> routesFromYear2 = routeRepository.findAllByDateBetween(year2MonthDayFirst, year2MonthDayLast);

            feesTotal1 = getFeesTotal(feesFromYear1);
            feesTotal2 = getFeesTotal(feesFromYear2);
            income1 = getIncome(routesFromYear1);
            income2 = getIncome(routesFromYear2);

            model.addAttribute("feesList1", feesFromYear1);
            model.addAttribute("feesList2", feesFromYear2);
            model.addAttribute("type", 2);
        }


        model.addAttribute("feesTotal1", feesTotal1);
        model.addAttribute("feesTotal2", feesTotal2);
        model.addAttribute("income1", income1);
        model.addAttribute("income2", income2);
        return "report/report-list";
    }

    public double getFeesTotal(List<CarFee> fees) {
        double feesTotal = 0;
        for (CarFee f : fees){
            feesTotal += f.getFee();
        }
        return feesTotal;
    }

    public double getIncome(List<Route> routes) {
        double income = 0;
        for (Route r : routes) {
            income += r.getPrice2() + r.getPrice3() + r.getPrice4() + r.getPrice5();
        }
        return income;
    }

}

//    @GetMapping("/list")
//    public String carFeeList(Model model) {
//        List<CarFee> carFeeByDate = carFeeRepository.findAllByDate(createDate());
//        model.addAttribute("carFeeByDate", carFeeByDate);
//        return "carFee/car-fee-list";
//    }
//
//    @GetMapping("/confirm-delete/{id}")
//    public String confirmDeleteCarFee(@PathVariable long id, Model model) {
//        CarFee carFee = carFeeRepository.findById(id);
//        model.addAttribute("carFee", carFee);
//        return "carFee/car-fee-confirm-delete";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteCarFee(@PathVariable long id) {
//        carFeeRepository.deleteById(id);
//        return "redirect:/car-fee/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editOdometerReading(@PathVariable long id,  Model model) {
//        CarFee carFee = carFeeRepository.findById(id);
//        model.addAttribute("carFee", carFee);
//        return "carFee/car-fee-form";
//    }

