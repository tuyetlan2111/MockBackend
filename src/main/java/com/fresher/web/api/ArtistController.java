package com.fresher.web.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fresher.web.entity.Artist;
import com.fresher.web.service.ArtistService;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	public static Logger logger = LoggerFactory.getLogger(ArtistController.class);
	
	@Autowired
	ArtistService artistService;
	
	@GetMapping("/show")
	public List<Artist> retrieveAllArtists() {
		return artistService.findAll();
	}
	
	@GetMapping("/show/{id}")
	public Artist retrieveArtist(@PathVariable int id) throws Exception {
		Optional<Artist> artist = artistService.findById(id);

		if (!artist.isPresent())
			throw new Exception("id-" + id);

		return artist.get();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createArtist(@RequestBody Artist artist) {
		Artist savedArtist = artistService.save(artist);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedArtist.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateArtist(@RequestBody Artist artist, @PathVariable int id) {

		Optional<Artist> productOptional = artistService.findById(id);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		artist.setId(id);
		
		artistService.save(artist);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteArtist(@PathVariable int id) {
		artistService.deleteById(id);
	}
}
