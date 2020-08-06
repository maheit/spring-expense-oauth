package com.maheit.expense.controllers;

import com.maheit.expense.entity.User;
import com.maheit.expense.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRespository userRepository;

    @GetMapping("/user/details")
    public Object getUserDetails() {
        // userRepository.findByEmail(email);
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}