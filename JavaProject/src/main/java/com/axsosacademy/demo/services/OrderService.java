package com.axsosacademy.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.Cart;
import com.axsosacademy.demo.models.Order;
import com.axsosacademy.demo.repositories.CartRepository;
import com.axsosacademy.demo.repositories.CategoryRepository;
import com.axsosacademy.demo.repositories.OrderRepository;
import com.axsosacademy.demo.repositories.PaintingRepository;
import com.axsosacademy.demo.repositories.UserRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final CategoryRepository categoryRepository;
	private final PaintingRepository paintingRepository;
	private final CartRepository cartRepository;
	private final UserRepository userRepository;
	
	public OrderService(OrderRepository orderRepository, UserRepository userRepository, PaintingRepository paintingRepository, CategoryRepository categoryRepository, CartRepository cartRepository) {

		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.paintingRepository = paintingRepository;
		this.cartRepository = cartRepository;
		this.userRepository = userRepository;
	}

	public void checkout(Long uid) {
		List<Cart> carts = cartRepository.findUserCartsNull(uid);
		Order order1 = new Order();
		orderRepository.save(order1);
		 for (Cart cart : carts) {
			    cart.setOrder(order1);
			    cartRepository.save(cart);
			}
		Order order = new Order();
		order.setCarts(carts);
		orderRepository.save(order);
	}

}
