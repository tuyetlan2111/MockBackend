package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Cart;
import com.fresher.web.entity.User;

public interface CartService extends JpaRepository<Cart, Integer>{
	
	public Cart findByCookie(String cookie);

}
