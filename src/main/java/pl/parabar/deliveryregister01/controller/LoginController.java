package pl.parabar.deliveryregister01.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.service.CurrentUser;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/logout")
    public String about() {
        return "logout"; }
}
