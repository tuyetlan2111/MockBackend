package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Rating;

public interface RatingService extends JpaRepository<Rating, Integer>{

}
