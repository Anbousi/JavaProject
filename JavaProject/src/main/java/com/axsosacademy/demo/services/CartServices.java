package com.axsosacademy.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Cart;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.repositories.CartRepository;
import com.axsosacademy.demo.repositories.CategoryRepository;
import com.axsosacademy.demo.repositories.PaintingRepository;
import com.axsosacademy.demo.repositories.UserRepository;

@Service
public class CartServices {
	private final CategoryRepository categoryRepository;
	private final PaintingRepository paintingRepository;
	private final CartRepository cartRepository;
	private final UserRepository userRepository;
	
	


	public CartServices(CategoryRepository categoryRepository, PaintingRepository paintingRepository,
			CartRepository cartRepository, UserRepository userRepository) {
		this.categoryRepository = categoryRepository;
		this.paintingRepository = paintingRepository;
		this.cartRepository = cartRepository;
		this.userRepository = userRepository;
	}




	public Cart addToCart(long pid, Long id) {
		Cart cart = new Cart();
		User user = userRepository.findById(id).orElse(null);
		if( user == null) {
			return null;
		}
		Painting painting = paintingRepository.findById(pid).orElse(null);
		cart.setUser(user);
		cart.setPainting(painting);
		return cartRepository.save(cart);
	}




	public List<Cart> getUserCarts(Long uid) {		
		return cartRepository.findUserCartsNull(uid);
	}


	public Cart removeFromCart(Long cid) {
		Cart cart = cartRepository.findById(cid).orElse(null);
		System.out.println(cart);
		if(cart == null) {
			return null;
		}
		cart.setUser(null);
		cart.setPainting(null);
		return cartRepository.save(cart);
	}

}
