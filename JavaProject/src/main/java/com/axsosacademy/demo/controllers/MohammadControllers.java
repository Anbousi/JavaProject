package com.axsosacademy.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MohammadControllers {
    private final UserService userService;
    private final UserValidator userValidator;
    private final PaintingService paintingService;
    private final CategoryService cateServ;
    

	 public MohammadControllers(UserService userService, UserValidator userValidator, PaintingService paintingService,
			CategoryService cateServ) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.paintingService = paintingService;
		this.cateServ = cateServ;
	}

	@RequestMapping("category/{cid}/painting/{id}")
	 public String showPainting(@PathVariable("id") long id,@PathVariable("cid") long cid, Model model, Principal principal) {
		 Painting painting = paintingService.findPaintingById(id);
		 model.addAttribute("painting",painting);
		 List <Category> categories = cateServ.getAllCategories();
		 model.addAttribute("categories" , categories);
		 model.addAttribute("principal",principal);
		Category cat = cateServ.findCategoryById(cid);
		model.addAttribute("category",cat);
		List<Painting> paintings = cat.getPaintings();
		model.addAttribute("paintings", paintings);
		 return "paintingInfo.jsp";
	 }
	
	 @RequestMapping("/cart")
	 public String showcart(Model model, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
//		 List<Painting> paintings = paintingService.
		 
		 return "cart.jsp";
	 }
	 
	 @RequestMapping("/cart/add_cart/{cid}/{pid}")
	 public String addcart(@PathVariable("cid") long cid ,@PathVariable("pid") long pid, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 	userService.addToCart(cid,pid,user.getId());
		 return "redirect:/cart";
	 }
    
}
