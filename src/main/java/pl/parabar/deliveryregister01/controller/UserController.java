package pl.parabar.deliveryregister01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.parabar.deliveryregister01.entity.Role;
import pl.parabar.deliveryregister01.entity.User;
import pl.parabar.deliveryregister01.repository.RoleRepository;
import pl.parabar.deliveryregister01.repository.UserRepository;
import pl.parabar.deliveryregister01.service.CurrentUser;
import pl.parabar.deliveryregister01.service.TimeService;
import pl.parabar.deliveryregister01.service.UserService;

import javax.validation.Valid;
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

    @GetMapping("/form-manager")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "user/user-form-manager";
    }

    @PostMapping("/form-manager")
    public String addUserProceed(@ModelAttribute @Valid User user,
                                   BindingResult result,
                                   @AuthenticationPrincipal CurrentUser customUser) {
        if (!result.hasErrors()) {
            if (user.getId() == 0) {
//                Role userRole = roleRepository.findByName("ROLE_DRIVER");
//                user.setEnabled(1);
//                user.setRole(userRole);
            }
            userService.saveUser(user, "ROLE_DRIVER");
            return "redirect:/user/list";
        } else {
            return "user/user-form-manager";
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
        return "user/user-form-manager";
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