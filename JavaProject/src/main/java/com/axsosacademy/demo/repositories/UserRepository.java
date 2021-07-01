package com.axsosacademy.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
