package pl.parabar.deliveryregister01.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.service.CurrentUser;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details for logged users"; }


    @RequestMapping("/dashboard")
    public String admin(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("hello", "Witaj, " + entityUser.getUsername());
        model.addAttribute("logout", "Wyloguj");
        return "dashboard";

    }

}
