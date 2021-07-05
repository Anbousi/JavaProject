package com.axsosacademy.demo.services;

import java.util.List;
import java.util.Optional;
import com.axsosacademy.demo.models.Category;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.repositories.CategoryRepository;
import com.axsosacademy.demo.repositories.PaintingRepository;


@Service
public class PaintingService {
	private final CategoryRepository categoryRepository;

	private final PaintingRepository paintingRepository;
	private final CategoryRepository categoryRepository;

	
<<<<<<< HEAD
public PaintingService(CategoryRepository categoryRepository , PaintingRepository paintingRepository) {
	this.categoryRepository = categoryRepository;
	this.paintingRepository = paintingRepository;
=======



	public PaintingService(PaintingRepository paintingRepository, CategoryRepository categoryRepository) {
		this.paintingRepository = paintingRepository;
		this.categoryRepository = categoryRepository;
>>>>>>> 7ee0acf35b6ab6ed19bd575a362b71e88b97700a
	}

	//	Add a New Painting
	public Painting addPainting(Painting painting) {
		return paintingRepository.save(painting);
	}

// Get All Paintings
	public List<Painting> getAllPaintings() {
		// TODO Auto-generated method stub
		return paintingRepository.findAll();
	}


	public void deletePaintning(long id) {
		paintingRepository.deleteById(id);		
	}

public Painting findPaintingById(Long id) {
	Optional<Painting> optionalPainting = paintingRepository.findById(id);
    if(optionalPainting.isPresent()) {
        return optionalPainting.get();
    } else {
       return null;
    }
<<<<<<< HEAD
    }
	//ayat
	public Painting getPainting(Long id) {
		Optional<Painting> myPainting = paintingRepository.findById(id);
		
		if(myPainting.isPresent()) {
			return myPainting.get();
		}else {
			return null;
		}
	}
=======
}
    
>>>>>>> 7ee0acf35b6ab6ed19bd575a362b71e88b97700a
	
	public List<Painting> getAll(){
		return (List<Painting>) paintingRepository.findAll();
	}
	
	public List<Painting> getAllExceptId(Long id){
		List<Painting> myPaintings = this.getAll();
		Optional<Category> x = categoryRepository.findById(id);
		if(x.isPresent()) {
			List<Painting> myCategoryPainting = x.get().getPaintings();
			myPaintings.removeAll(myCategoryPainting);
			return myPaintings;
		}else {
			return null;
		}
}



}


