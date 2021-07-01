package com.axsosacademy.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Painting;


@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long> {
}
