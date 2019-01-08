package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Product;

public interface ProductService extends JpaRepository<Product, Integer>{

}
