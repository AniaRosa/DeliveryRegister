package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.Route;
import pl.parabar.deliveryregister01.repository.RouteRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/route", produces = "text/plain;charset=utf-8")
public class RouteController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private RouteRepository routeRepository;


    public String createDate() {
        return timeService.getDate();
    }

    public String createTime() {
        return timeService.getTime();
    }

    @ModelAttribute("deliveriesNumber")
    public List<String> deliveriesNumber() {
        List<String> deliveriesNumber = Arrays.asList("1", "2", "3", "4");
        return deliveriesNumber;
    }

    @GetMapping("/form/deliveries-number/{id}")
    public String getDeliveriesNumber(@PathVariable long id, Model model) {
        if (id == 0) {
            model.addAttribute("route", new Route());
        } else {
            model.addAttribute("route", routeRepository.findById(id));
        }
        return "route/route-form-deliveries-number";
    }

    @GetMapping("/form/{id}")
    public String addRoute(@RequestParam long numberOfDeliveries, @PathVariable long id) {
        return "redirect:/route/form/" + numberOfDeliveries + "/" + id;
    }

    @GetMapping("/form/{numberOfDeliveries}/{id}")
    public String addRoute2(@PathVariable long numberOfDeliveries, @PathVariable long id, Model model) {

        model.addAttribute("numberOfDeliveries", numberOfDeliveries);
        if (id == 0) {
            model.addAttribute("route", new Route());
        } else {
            model.addAttribute("route", routeRepository.findById(id));
        }
        model.addAttribute("bar", "Katowicka 67C, Poznań");

        return "route/route-form";
    }

    @PostMapping("/form/{numberOfDeliveries}")
    public String addRouteProceed(@PathVariable long numberOfDeliveries, Model model, @ModelAttribute @Valid Route route,
                                   BindingResult result,
                                   @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (route.getId() == 0) {
                route.setDate(createDate());
                route.setTime(createTime());
                route.setUser(customUser.getUser());
                route.setDeliveries(numberOfDeliveries);
                if (route.getAddress1().isEmpty()) {
                    route.setAddress1("Katowicka 67C, Poznań");
                }
                if (route.getAddress6().isEmpty()) {
                    route.setAddress6("Katowicka 67C, Poznań");
                }
            }
            routeRepository.save(route);
            return "redirect:/route/list";
        } else {
            model.addAttribute("numberOfDeliveries", numberOfDeliveries);
            return "route/route-form";
        }
    }

    @GetMapping("/list")
    public String routeList(Model model) {
        List<Route> routeByDate = routeRepository.findAllByDate(createDate());
        model.addAttribute("routeByDate", routeByDate);
        return "route/route-list";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteRoute(@PathVariable long id, Model model) {
        Route route = routeRepository.findById(id);
        model.addAttribute("route", route);
        return "route/route-confirm-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoute(@PathVariable long id) {
        routeRepository.deleteById(id);
        return "redirect:/route/list";
    }

    @GetMapping("/edit/{id}")
    public String editRoute(@PathVariable long id, Model model) {
        Route route = routeRepository.findById(id);
        long numberOfDeliveries = route.getDeliveries();
        model.addAttribute("route", route);
        model.addAttribute("numberOfDeliveries", numberOfDeliveries);
        return "route/route-form";
    }

}
