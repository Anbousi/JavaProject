package com.axsosacademy.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
	
	
	@Query(value="SELECT * From carts WHERE user_id = ?1 && order_id IS NULL", nativeQuery=true)
	List<Cart> findUserCartsNull(Long uid);

}
