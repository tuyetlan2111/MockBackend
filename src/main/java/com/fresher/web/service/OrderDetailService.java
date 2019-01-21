package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fresher.web.entity.OrderDetail;

public interface OrderDetailService extends JpaRepository<OrderDetail, Integer>{
	@Query(value = "SELECT OD.* from OrderProduct OP join OrderDetail OD on OP.id = OD.order_id where  OP.user_id = ?1", nativeQuery = true)
	public OrderDetail findByUserId(int user_id);
}
