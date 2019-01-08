package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.OrderDetail;

public interface OrderDetailService extends JpaRepository<OrderDetail, Integer>{

}
