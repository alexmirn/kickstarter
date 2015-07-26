package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsServiceExtended extends UserDetailsService {
    User getUserByLogin(String login);

    User getById(Integer userId);

    void create(User user);

    void update(User user);

    void delete(User user);
}