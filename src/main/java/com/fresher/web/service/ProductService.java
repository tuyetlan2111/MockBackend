package com.fresher.web.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fresher.web.entity.Product;
import com.fresher.web.service.custom.ProductServiceCustom;

@Repository
public interface ProductService extends JpaRepository<Product, Integer>, ProductServiceCustom{
	 @Query(value = "Select id, title, price, image from Product ?1", nativeQuery = true)
    List<Product> findAllProductsByQuery( String where);
}