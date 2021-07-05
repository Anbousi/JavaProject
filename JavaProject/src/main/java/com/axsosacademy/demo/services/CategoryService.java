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
	//ayat
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Category getCategory(Long id) {
		Optional<Category> myCategory = categoryRepository.findById(id);
		if (myCategory.isPresent()) {
			return myCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> getAllExceptId(Long id) {
		List<Category> myCategories = this.getAll();
		Optional<Painting> x = paintingRepository.findById(id);
		if (x.isPresent()) {
			Category myPaintingCategory = x.get().getCategory();
			myCategories.remove(myPaintingCategory); //List<Category> myPaintingCategory = x.get().getCategory();
													   //myCategories.removeAll(myPaintingCategory);
			return myCategories;
		} else {
			return null;
		}

	}

}
