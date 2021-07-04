package com.axsosacademy.demo.services;

import java.util.Optional;

import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.repositories.PaintingRepository;

public class PaintingService {
	
	 	private PaintingRepository paintingRepository;	   
		




public PaintingService(PaintingRepository paintingRepository) {
	this.paintingRepository = paintingRepository;
}

public Painting findPaintingById(Long id) {
	Optional<Painting> optionalPainting = paintingRepository.findById(id);
    if(optionalPainting.isPresent()) {
        return optionalPainting.get();
    } else {
        return null;
    }
}



}


