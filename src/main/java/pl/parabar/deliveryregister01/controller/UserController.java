package pl.parabar.deliveryregister01.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-users")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user, "ROLE_ADMIN");

        User user2 = new User();
        user2.setFirstName("manager");
        user2.setLastName("manager");
        user2.setUsername("manager");
        user2.setPassword("manager");
        userService.saveUser(user2, "ROLE_MANAGER");

        User user3 = new User();
        user3.setFirstName("driver");
        user3.setLastName("driver");
        user3.setUsername("driver");
        user3.setPassword("driver");
        userService.saveUser(user3, "ROLE_DRIVER");

        return "done";
    }

    @RequestMapping("/dashboard")
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "dashboard";

    }

}