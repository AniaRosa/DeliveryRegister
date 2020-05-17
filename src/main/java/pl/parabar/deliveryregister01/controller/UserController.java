package pl.parabar.deliveryregister01.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user, "ROLE_ADMIN");
        return "done";
    }

    @PostMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
        //return "admin";
    }

}