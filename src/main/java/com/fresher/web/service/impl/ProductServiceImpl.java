package com.fresher.web.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fresher.web.entity.Product;
import com.fresher.web.service.custom.ProductServiceCustom;

public class ProductServiceImpl implements ProductServiceCustom{

	@PersistenceContext
    EntityManager entityManager;
 

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByTitle(String title) {
		Query query = entityManager.createNativeQuery("SELECT * FROM product p WHERE p.title LIKE ? ", Product.class);
        query.setParameter(1, "%" + title + "%");
 
        return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByPrice(int price) {
		Query query = entityManager.createNativeQuery("SELECT * FROM product p WHERE p.price = ? ", Product.class);
        query.setParameter(1, price);
 
        return query.getResultList();
	}
}
