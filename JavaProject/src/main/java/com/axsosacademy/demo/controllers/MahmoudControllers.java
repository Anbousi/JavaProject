package com.axsosacademy.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.PaintingValidator;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MahmoudControllers {
    private final UserService userService;
    private final PaintingService paintingService;
    private final UserValidator userValidator;
    private final PaintingValidator paintingValidator;
    
    

	


	public MahmoudControllers(UserService userService, PaintingService paintingService, UserValidator userValidator,
			PaintingValidator paintingValidator) {
		this.userService = userService;
		this.paintingService = paintingService;
		this.userValidator = userValidator;
		this.paintingValidator = paintingValidator;
	}

	@RequestMapping("/admin/add_painting")
    public String viewPage(@ModelAttribute("painting") Painting painting) {
        return "addPainting.jsp";
    } 
	
    @PostMapping("/admin/add_painting")
    public String registration(@Valid @ModelAttribute("painting") Painting painting, BindingResult result, Model model, HttpSession session) {
        System.out.println("Create a painting");
        
        if (result.hasErrors()) {
        	System.out.println("error");
            return "addPainting.jsp";
        } 
        
        paintingService.addPainting(painting);
        System.out.println("created");
        return "/admin/show_paintings.jps";
    }
    

    
    

}
