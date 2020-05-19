package pl.parabar.deliveryregister01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.parabar.deliveryregister01.entity.Route;

import java.time.LocalDate;

@Controller
public class RouteController {

    @GetMapping("/add-route")
    public String addRoute(Model model) {

        String date = String.valueOf(LocalDate.now());
        model.addAttribute("date", date);
        model.addAttribute("route", new Route());
        return "add-route";
    }
}
