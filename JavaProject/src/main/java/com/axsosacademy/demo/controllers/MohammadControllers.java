package com.axsosacademy.demo.controllers;

<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
=======
import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 7ee0acf35b6ab6ed19bd575a362b71e88b97700a
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.axsosacademy.demo.models.Category;
<<<<<<< HEAD
import com.axsosacademy.demo.models.FileUploadUtil;
import com.axsosacademy.demo.services.CategoryService;
=======
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
>>>>>>> 7ee0acf35b6ab6ed19bd575a362b71e88b97700a
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

@Controller
public class MohammadControllers {
    private final UserService userService;
<<<<<<< HEAD
    private  final UserValidator userValidator;
    private final CategoryService cateServ;
    

   
public MohammadControllers(UserService userService, UserValidator userValidator, CategoryService cateServ) {
		
		this.userService = userService;
		this.userValidator = userValidator;
		this.cateServ = cateServ;
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
=======
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
    
>>>>>>> 7ee0acf35b6ab6ed19bd575a362b71e88b97700a
}
