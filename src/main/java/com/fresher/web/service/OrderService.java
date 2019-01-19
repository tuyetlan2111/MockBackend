package com.fresher.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Order;

public interface OrderService extends JpaRepository<Order, Integer>{
	public List<Order> findByUserId(int id);
}
