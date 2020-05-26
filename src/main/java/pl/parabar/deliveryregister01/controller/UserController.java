package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.repository.RoleRepository;
import pl.parabar.deliveryregister01.repository.UserRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;
import pl.parabar.deliveryregister01.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private TimeService timeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String createDate() {
        return timeService.getDate();
    }

    public List<String> getUsernames() {
        List<User> users = userRepository.findAll();
        List<String> usernames = new ArrayList<>();
        for (User u : users) {
            usernames.add(u.getFirstName());
        }
        return usernames;
    }

    @GetMapping("/form-driver")
    public String addDriver(Model model) {

        model.addAttribute("user", new User());
        return "user/user-form-driver";
    }

    @PostMapping("/form-driver")
    public String addDriverProceed(@ModelAttribute @Valid User user,
                                   BindingResult result,
                                   @AuthenticationPrincipal CurrentUser customUser,
                                   Model model) {
        if (!result.hasErrors()) {
            String usernameToCheck = user.getUsername();
            for (String u : getUsernames()) {
                if (u.equals(usernameToCheck)) {
                    model.addAttribute("usernameExists", "Użytkownik o takiej nazwie już istnieje");
                    return "user/user-form-driver";
                }
            }
            userService.saveUser(user, "ROLE_DRIVER");
            return "redirect:/user/list";
        } else {
            return "user/user-form-driver";
        }
    }

    @GetMapping("/form-manager")
    public String addManager(Model model) {

        model.addAttribute("user", new User());
        return "user/user-form-manager";
    }

    @PostMapping("/form-manager")
    public String addManagerProceed(@ModelAttribute @Valid User user,
                                    BindingResult result,
                                    @AuthenticationPrincipal CurrentUser customUser,
                                    Model model) {
        if (!result.hasErrors()) {
            String usernameToCheck = user.getUsername();
            for (String u : getUsernames()) {
                if (u.equals(usernameToCheck)) {
                    model.addAttribute("usernameExists", "Użytkownik o takiej nazwie już istnieje");
                    return "user/user-form-manager";
                }
            }
            userService.saveUser(user, "ROLE_MANAGER");
            return "redirect:/user/list";
        } else {
            return "user/user-form-manager";
        }
    }

    @GetMapping("/form-admin")
    public String addAdmin(Model model) {

        model.addAttribute("user", new User());
        return "user/user-form-admin";
    }

    @PostMapping("/form-admin")
    public String addAdminProceed(@ModelAttribute @Valid User user,
                                 BindingResult result,
                                 @AuthenticationPrincipal CurrentUser customUser,
                                  Model model) {
        if (!result.hasErrors()) {
            String usernameToCheck = user.getUsername();
            for (String u : getUsernames()) {
                if (u.equals(usernameToCheck)) {
                    model.addAttribute("usernameExists", "Użytkownik o takiej nazwie już istnieje");
                    return "user/user-form-admin";
                }
            }
            userService.saveUser(user, "ROLE_ADMIN");
            return "redirect:/user/list";
        } else {
            return "user/user-form-admin";
        }
    }


    @GetMapping("/list")
    public String userList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/user-list";
    }

    @GetMapping("/confirm-delete/{id}")
    public String confirmDeleteUser(@PathVariable long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user/user-confirm-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable long id,  Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "user/user-form-driver";
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

}