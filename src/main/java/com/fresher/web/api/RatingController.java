package com.fresher.web.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fresher.web.entity.Order;
import com.fresher.web.entity.OrderDetail;
import com.fresher.web.entity.Product;
import com.fresher.web.entity.Rating;
import com.fresher.web.service.OrderDetailService;
import com.fresher.web.service.ProductService;
import com.fresher.web.service.RatingService;

@RestController
@RequestMapping("/rating")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingController {
	public static Logger logger = LoggerFactory.getLogger(RatingController.class);

	@Autowired
	RatingService ratingService;

	@Autowired
	ProductService productService;
	
	@Autowired
	OrderDetailService detailService;
	
	@GetMapping("/show")
	public List<Rating> retrieveAllRatings() {
		return ratingService.findAll();
	}

	@GetMapping("/show/{id}")
	public List<Rating> retrieveRating(@PathVariable int id) throws Exception {
		List<Rating> ratings = ratingService.findByProductId(id);

		return ratings;
	}
	@GetMapping("/avg/{id}")
	public int getRatingProduct(@PathVariable int id) throws Exception {
		int rating = ratingService.getAverageRating(id);
		return rating;
	}
	@PostMapping("/create")
	public Rating createRating(@RequestBody Rating rating) {
		OrderDetail detail = detailService.findByUserId(rating.getUser().getId());
		
		if(detail!=null) {
			
			List<Rating> rts = ratingService.findByProductIdAndUserId(rating.getProduct().getId(), rating.getUser().getId());
			if(rts.size() == 0) {
				Rating savedRating = ratingService.save(rating);
				Product product = rating.getProduct();
				int star = ratingService.getAverageRating(product.getId());
				
				product.setAvgStars(star);
				productService.save(product);
				
				return rating;
			}
			
		}
		
		return null;

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateRating(@RequestBody Rating rating, @PathVariable int id) {

		Optional<Rating> ratingOptional = ratingService.findById(id);

		if (!ratingOptional.isPresent())
			return ResponseEntity.notFound().build();

		rating.setId(id);

		ratingService.save(rating);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		ratingService.deleteById(id);
	}
}
