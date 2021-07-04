package com.axsosacademy.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
   
//	 @RequestMapping("/category/details")
//	 public String showitemis() {
//		 return "category_information.jsp";
//	 }
	 @RequestMapping("category/category/details/cart")
	 public String showcart() {
		 return "cart.jsp";
	 }
    
}
