package com.axsosacademy.demo.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MainController {
	
    private UserService userService;
    private UserValidator userValidator;
    

    
    public MainController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/")
    public String viewPage() {
        return "viewPage.jsp";
    }  
    
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Email or Password is incorrect, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = { "/home"})
    public String home(Principal principal, Model model) {
//        String username = principal.getName();
//        System.out.println(username);
//        model.addAttribute("currentUser", userService.findByUsername(username));
        return "homePage.jsp";
    }
    
    
    @RequestMapping(value="/admin", method=RequestMethod.GET)    
    public String admin() {    
            
        return "adminPage.jsp";    
    }  

}
