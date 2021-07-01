package com.axsosacademy.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
