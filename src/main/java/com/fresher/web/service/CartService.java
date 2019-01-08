package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Cart;

public interface CartService extends JpaRepository<Cart, Integer>{

}
