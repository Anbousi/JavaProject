package com.axsosacademy.demo.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.FileUploadUtil;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

@Controller
public class MohammadControllers {
    private final UserService userService;
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
}
