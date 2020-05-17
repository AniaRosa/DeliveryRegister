package pl.parabar.deliveryregister01.service;

import pl.parabar.deliveryregister01.entity.Role;
import pl.parabar.deliveryregister01.entity.User;

public interface UserService {

    User findByUsername(String username);

    void saveUser(User user, String role);
}