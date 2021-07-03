package com.axsosacademy.demo.controllers;

import org.springframework.stereotype.Controller;

import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MahmoudControllers {
    private UserService userService;
    private UserValidator userValidator;
    
	public MahmoudControllers(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
    
    

}
