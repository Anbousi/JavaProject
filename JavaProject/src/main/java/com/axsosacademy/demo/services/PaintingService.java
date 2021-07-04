package com.axsosacademy.demo.services;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.repositories.PaintingRepository;


@Service
public class PaintingService {
	
	private final PaintingRepository paintingRepository;

	
public PaintingService(PaintingRepository paintingRepository) {
		this.paintingRepository = paintingRepository;
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
}



}


