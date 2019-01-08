package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.CartItem;

public interface CartItemService extends JpaRepository<CartItem, Integer>{

}
