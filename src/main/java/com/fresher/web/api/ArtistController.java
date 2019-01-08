package com.fresher.web.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fresher.web.entity.Artist;
import com.fresher.web.service.ArtistService;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	public static Logger logger = LoggerFactory.getLogger(ArtistController.class);
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping(value = "/show/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Artist>> listAllArtist(){
		List<Artist> listArtist= artistService.findAll();
		if(listArtist.isEmpty()) {
			return new ResponseEntity<List<Artist>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Artist>>(listArtist, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Artist findArtist(@PathVariable("id") int id) {
		Artist artist= artistService.getOne(id);
		if(artist == null) {
			ResponseEntity.notFound().build();
		}
		return artist;
	}
	
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public Artist saveContact(@Valid @RequestBody Artist artist) {
		return artistService.save(artist);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") int artistId, 
	                                       @Valid @RequestBody Artist artistForm) {
		Artist artist = artistService.getOne(artistId);
	    if(artist == null) {
	        return ResponseEntity.notFound().build();
	    }
	    artist.setFirstName(artistForm.getFirstName());
	    artist.setLastName(artistForm.getLastName());

	    Artist updatedArtist = artistService.save(artist);
	    return ResponseEntity.ok(updatedArtist);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Artist> deleteArtist(@PathVariable(value = "id") int id) {
		Artist artist = artistService.getOne(id);
	    if(artist == null) {
	        return ResponseEntity.notFound().build();
	    }

	    artistService.delete(artist);
	    return ResponseEntity.ok().build();
	}
}
