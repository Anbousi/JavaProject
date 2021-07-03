package com.axsosacademy.demo.controllers;

import org.springframework.stereotype.Controller;

import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MohammadControllers {
    private UserService userService;
    private UserValidator userValidator;
    
	public MohammadControllers(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
    
    
}
