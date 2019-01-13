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

import com.fresher.web.entity.Err;
import com.fresher.web.service.ErrService;

@RestController
@RequestMapping("/error")
@CrossOrigin(origins = "http://localhost:4200")
public class ErrController {
	
public static Logger logger = LoggerFactory.getLogger(ErrController.class);
	
	@Autowired
	ErrService errService;
	
	@GetMapping("/show")
	public List<Err> retrieveAllErrs() {
		return errService.findAll();
	}
	
	@GetMapping("/show/{id}")
	public Err retrieveErr(@PathVariable int id) throws Exception {
		Optional<Err> err = errService.findById(id);

		if (!err.isPresent())
			throw new Exception("id-" + id);

		return err.get();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createErr(@RequestBody Err err) {
		Err savedErr = errService.save(err);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedErr.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateErr(@RequestBody Err err, @PathVariable int id) {

		Optional<Err> errOptional = errService.findById(id);

		if (!errOptional.isPresent())
			return ResponseEntity.notFound().build();

		err.setId(id);
		
		errService.save(err);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteErr(@PathVariable int id) {
		errService.deleteById(id);
	}
}
