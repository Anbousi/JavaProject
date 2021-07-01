package com.axsosacademy.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
