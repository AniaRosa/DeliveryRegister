package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.OdometerReading;
import pl.parabar.deliveryregister01.entity.Refuel;
import pl.parabar.deliveryregister01.repository.OdometerReadingRepository;
import pl.parabar.deliveryregister01.repository.RefuelRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/refuel")
public class RefuelController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private RefuelRepository refuelRepository;

    public String createDate() {
        return timeService.getDate();
    }

    public String createTime() {
        return timeService.getTime();
    }

    @ModelAttribute("fuelTypes")
    public List<String> fuelTypes() {
        List<String> fuelTypes = Arrays.asList("benzyna", "gaz");
        return fuelTypes;
    }


    @GetMapping("/form")
    public String addRefuel(Model model) {

        model.addAttribute("refuel", new Refuel());
        return "refuel/refuel-form";
    }

    @PostMapping("/form")
    public String addRefuelProceed(@ModelAttribute @Valid Refuel refuel,
                                            BindingResult result,
                                            @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (refuel.getId() == 0) {
                refuel.setDate(createDate());
                refuel.setTime(createTime());
                refuel.setUser(customUser.getUser());
            }
            refuelRepository.save(refuel);
            return "redirect:/refuel/list";
        } else {
            return "refuel/refuel-form";
        }
    }

    @GetMapping("/list")
    public String refuelList(Model model) {
        List<Refuel> refuelByDate = refuelRepository.findAllByDate(createDate());
        model.addAttribute("refuelByDate", refuelByDate);
        return "refuel/refuel-list";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteRefuel(@PathVariable long id, Model model) {
        Refuel refuel = refuelRepository.findById(id);
        model.addAttribute("refuel", refuel);
        return "refuel/refuel-confirm-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteRefuel(@PathVariable long id) {
        refuelRepository.deleteById(id);
        return "redirect:/refuel/list";
    }

    @GetMapping("/edit/{id}")
    public String editRefuel(@PathVariable long id,  Model model) {
        Refuel refuel = refuelRepository.findById(id);
        model.addAttribute("refuel", refuel);
        return "refuel/refuel-form";
    }
}
