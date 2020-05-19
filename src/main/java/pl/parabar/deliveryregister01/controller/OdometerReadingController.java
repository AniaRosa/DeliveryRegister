package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.parabar.deliveryregister01.entity.OdometerReading;
import pl.parabar.deliveryregister01.entity.Route;
import pl.parabar.deliveryregister01.repository.OdometerReadingRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;


@Controller
public class OdometerReadingController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private OdometerReadingRepository odometerReadingRepository;


    @GetMapping("/add-odometer-reading")
    public String addOdometerReading(Model model) {

        model.addAttribute("odometerReading", new OdometerReading());
        return "add-odometer-reading";
    }

    @PostMapping("/add-odometer-reading")
    public String addOdometerReadingProceed(@ModelAttribute @Valid OdometerReading odometerReading,
                                            BindingResult result,
                                            @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (odometerReading.getId() == 0) {
                odometerReading.setDate(timeService.getDate());
                odometerReading.setTime(timeService.getTime());
                odometerReading.setUser(customUser.getUser());
            }
            odometerReadingRepository.save(odometerReading);
            return "/dashboard";
        } else {
            return "add-odometer-reading";
        }
    }
}
