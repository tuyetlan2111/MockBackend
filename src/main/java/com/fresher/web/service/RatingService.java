package com.fresher.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fresher.web.entity.Rating;

public interface RatingService extends JpaRepository<Rating, Integer>{
	 @Query(value = "SELECT AVG(r.stars) from Rating r where product_id = ?1", nativeQuery = true)
	 int getAverageRating(int productId);
	 public List<Rating> findByProductId(int productId);
	 public List<Rating> findByProductIdAndUserId(int productId, int UserId);
}
