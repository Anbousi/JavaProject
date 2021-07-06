package com.axsosacademy.demo.controllers;


import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsosacademy.demo.models.Cart;
import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.CartServices;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.OrderService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class MohammadControllers {
    private final UserService userService;
    private final UserValidator userValidator;
    private final PaintingService paintingService;
    private final CategoryService cateServ;
    private final CartServices cartServices;
    private final OrderService orderServices;
    



	public MohammadControllers(UserService userService, UserValidator userValidator, PaintingService paintingService,
			CategoryService cateServ, CartServices cartServices, OrderService orderServices) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.paintingService = paintingService;
		this.cateServ = cateServ;
		this.cartServices = cartServices;
		this.orderServices = orderServices;
	}

//	 @RequestMapping("/category/details")
//	 public String showitemis() {
//		 return "category_information.jsp";
//	 }
	 @RequestMapping("category/category/details/cart")
	 public String showcart() {
		 return "cart.jsp";
	 }
//    
//	 @PostMapping("admin/add_category")
//	   public RedirectView saveCategory(Category category,@RequestParam("image") MultipartFile multipartFile)
//	   		throws IOException {
//		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 category.setPic(fileName);
//		 
//		 Category savedCategory = cateServ.save(category);
//		 String uploadDir = "category-photos/" + savedCategory.getId();
//		 
//		 FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//	       return new RedirectView("/"+ true);
//}



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
		 List<Cart> carts = cartServices.getUserCarts(user.getId());
		 model.addAttribute("carts", carts);
		 Double total = (double) 0;
		 for (Cart cart : carts) {
			    total = total + cart.getPainting().getPrice();
			}
		 model.addAttribute("total",total);
		 return "cart.jsp";
	 }
	 
	 @RequestMapping("/cart/add_cart/{cid}/{pid}")
	 public String addCart(@PathVariable("cid") long cid ,@PathVariable("pid") long pid, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 cartServices.addToCart(pid,user.getId());
		 return "redirect:/cart";
	 }
	 
	 @RequestMapping("/cart/delete/{cid}")
	 public String removeCart(@PathVariable("cid") long cid, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 cartServices.removeFromCart(cid);
		 return "redirect:/cart";
	 }
	 
	 @RequestMapping("/cart/checkout")
	 public String checkout(Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 orderServices.checkout(user.getId());
		 return "redirect:/done";
	 }
	 
	 @RequestMapping("/cart/done")
	 public String done(Principal principal) {
		 return "done.jsp";
	 }
    
}
