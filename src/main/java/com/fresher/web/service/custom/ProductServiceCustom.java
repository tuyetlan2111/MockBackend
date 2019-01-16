package com.fresher.web.service.custom;

import java.util.List;

import com.fresher.web.entity.Product;

public interface ProductServiceCustom {

	List<Product> findByTitle(String title);
	
	List<Product> findByPrice(int price);
	
}
