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
 

	@Override
	public List<Product> findByTitle(String title) {
		Query query = entityManager.createNativeQuery("select * from product p where p.title  LIKE ? ", Product.class);
        query.setParameter(1, "%" + title + "%");
 
        return query.getResultList();
	}
	
	@Override
	public List<Product> findByPrice(int price) {
		Query query = entityManager.createNativeQuery("select * from product p where p.price  = ? ", Product.class);
        query.setParameter(1, price);
 
        return query.getResultList();
	}
}
