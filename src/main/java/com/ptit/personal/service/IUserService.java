package com.ptit.personal.service;

import com.ptit.personal.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    UserDetails loadUserByUsername(String username);

    public User addUser(User user);
}
