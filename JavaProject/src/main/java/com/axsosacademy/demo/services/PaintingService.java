package com.axsosacademy.demo.services;

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

}
