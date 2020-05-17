package pl.parabar.deliveryregister01.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private final pl.parabar.deliveryregister01.entity.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                       pl.parabar.deliveryregister01.entity.User user) {

        super(username, password, authorities);
        this.user = user;
    }

    public pl.parabar.deliveryregister01.entity.User getUser() {return user;}
}