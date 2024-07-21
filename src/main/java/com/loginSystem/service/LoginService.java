package com.loginSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginSystem.entity.User;
import com.loginSystem.repository.UserRepository;

@Service
public class LoginService {
	
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

