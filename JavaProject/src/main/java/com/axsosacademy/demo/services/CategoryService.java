package com.axsosacademy.demo.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;


import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.repositories.CategoryRepository;




@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}



	public void addCategory(Category category) {
		categoryRepository.save(category);
	}



	public List<Category> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}


	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

}
