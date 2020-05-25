package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.CarFee;
import pl.parabar.deliveryregister01.entity.OdometerReading;
import pl.parabar.deliveryregister01.repository.CarFeeRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/car-fee")
public class CarFeeController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private CarFeeRepository carFeeRepository;

    public String createDate() {
        return timeService.getDate();
    }

    @GetMapping("/form")
    public String addCarFee(Model model) {

        model.addAttribute("carFee", new CarFee());
        return "carFee/car-fee-form";
    }

    @PostMapping("/form")
    public String addCarFeeProceed(@ModelAttribute @Valid CarFee carFee,
                                            BindingResult result,
                                            @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (carFee.getId() == 0) {
                carFee.setDate(createDate());
                carFee.setUser(customUser.getUser());
            }
            carFeeRepository.save(carFee);
            return "redirect:/car-fee/list";
        } else {
            return "carFee/car-fee-form";
        }
    }

    @GetMapping("/list")
    public String carFeeList(Model model) {
        List<CarFee> carFeeByDate = carFeeRepository.findAllByDate(createDate());
        model.addAttribute("carFeeByDate", carFeeByDate);
        return "carFee/car-fee-list";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteCarFee(@PathVariable long id, Model model) {
        CarFee carFee = carFeeRepository.findById(id);
        model.addAttribute("carFee", carFee);
        return "carFee/car-fee-confirm-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarFee(@PathVariable long id) {
        carFeeRepository.deleteById(id);
        return "redirect:/car-fee/list";
    }

    @GetMapping("/edit/{id}")
    public String editOdometerReading(@PathVariable long id,  Model model) {
        CarFee carFee = carFeeRepository.findById(id);
        model.addAttribute("carFee", carFee);
        return "carFee/car-fee-form";
    }
}
