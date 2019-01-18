package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Payment;

public interface PaymentService extends JpaRepository<Payment, Integer>{

}
