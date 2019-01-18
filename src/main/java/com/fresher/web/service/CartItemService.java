package com.fresher.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.CartItem;

public interface CartItemService extends JpaRepository<CartItem, Integer>{
	public CartItem findByProductIdAndCartId(int productID, int cartId);
	public List<CartItem> findByCartId(int cartId);
}
