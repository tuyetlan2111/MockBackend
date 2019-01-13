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

import com.fresher.web.entity.Rating;
import com.fresher.web.service.RatingService;

@RestController
@RequestMapping("/rating")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingController {
	public static Logger logger = LoggerFactory.getLogger(RatingController.class);

	@Autowired
	RatingService ratingService;

	@GetMapping("/show")
	public List<Rating> retrieveAllRatings() {
		return ratingService.findAll();
	}

	@GetMapping("/show/{id}")
	public Rating retrieveRating(@PathVariable int id) throws Exception {
		Optional<Rating> rating = ratingService.findById(id);

		if (!rating.isPresent())
			throw new Exception("id-" + id);

		return rating.get();
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createRating(@RequestBody Rating rating) {
		Rating savedRating = ratingService.save(rating);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRating.getId()).toUri();

		return ResponseEntity.created(location).build();

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
