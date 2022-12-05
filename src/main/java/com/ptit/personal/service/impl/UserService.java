
package com.ptit.personal.service.impl;

import com.ptit.personal.entity.User;
import com.ptit.personal.repository.UserRepository;
import com.ptit.personal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailSecurity(user);
    }

    public User addUser(User user) {
        boolean checkExists = userRepository.existsByUsername(user.getUsername());
        if (!checkExists) {
            return userRepository.save(user);
        }
        return null;
    }
}
