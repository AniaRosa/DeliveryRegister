package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.OdometerReading;
import pl.parabar.deliveryregister01.repository.OdometerReadingRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/odometer-reading")
public class OdometerReadingController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private OdometerReadingRepository odometerReadingRepository;

    public String createDate() {
        return timeService.getDate();
    }

    public String createTime() {
        return timeService.getTime();
    }


    @GetMapping("/form")
    public String addOdometerReading(Model model) {

        model.addAttribute("odometerReading", new OdometerReading());
        return "odometerReading/odometer-reading-form";
    }

    @PostMapping("/form")
    public String addOdometerReadingProceed(@ModelAttribute @Valid OdometerReading odometerReading,
                                            BindingResult result,
                                            @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (odometerReading.getId() == 0) {
                odometerReading.setDate(createDate());
                odometerReading.setTime(createTime());
                odometerReading.setUser(customUser.getUser());
            }
            odometerReadingRepository.save(odometerReading);
            return "redirect:/odometer-reading/list";
        } else {
            return "odometerReading/odometer-reading-form";
        }
    }

    @GetMapping("/list")
    public String odometerReadingList(Model model) {
        List<OdometerReading> odometerReadingsByDate = odometerReadingRepository.findAllByDate(createDate());
        model.addAttribute("odometerReadingsByDate", odometerReadingsByDate);
        return "odometerReading/odometer-reading-list";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteOdometerReading(@PathVariable long id, Model model) {
        OdometerReading odometerReading = odometerReadingRepository.findById(id);
        model.addAttribute("odometerReading", odometerReading);
        return "odometerReading/odometer-reading-confirm-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteOdometerReading(@PathVariable long id) {
        odometerReadingRepository.deleteById(id);
        return "redirect:/odometer-reading/list";
    }

    @GetMapping("/edit/{id}")
    public String editOdometerReading(@PathVariable long id,  Model model) {
        OdometerReading odometerReading = odometerReadingRepository.findById(id);
        model.addAttribute("odometerReading", odometerReading);
        return "odometerReading/odometer-reading-form";
    }
}
