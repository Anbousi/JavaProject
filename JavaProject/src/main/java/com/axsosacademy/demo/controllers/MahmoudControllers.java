package com.axsosacademy.demo.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MahmoudControllers {
    private UserService userService;
    private UserValidator userValidator;
    private PaintingService paintingService;
  
    
	public MahmoudControllers(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
    
//	 @RequestMapping("/category/{id}/details")
//	    public String index(Model model , Long id) {
//	        List<Painting> panting =  paintingService.findPaintingById(id);
//	        model.addAttribute("panting", panting);
//	        return "/books/index.jsp";
//	    }

	 @RequestMapping("/category/details")
	 public String showitemis() {
		 return "category_information.jsp";
	 }

}

