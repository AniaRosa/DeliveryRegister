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
import pl.parabar.deliveryregister01.repository.CarFeeRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private CarFeeRepository carFeeRepository;

    public String createDate() {
        return timeService.getDate();
    }

    @ModelAttribute("months")
    public List<Integer> months() {
        List<Integer> months = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
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
        if (report.getType().equals("miesiąc")) {

            String date1 = String.valueOf(LocalDate.of(report.getYears().get(0), report.getMonths().get(0), 1));
            String date2 = String.valueOf(LocalDate.of(report.getYears().get(0), report.getMonths().get(0), 31));

            List<CarFee> fees = carFeeRepository.findAllByDateBetween(date1, date2);
            model.addAttribute("list", fees);
            return "report/report-list";
        }
        return "report/report-list";

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
}
