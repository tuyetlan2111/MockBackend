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

import com.fresher.web.entity.Product;
import com.fresher.web.service.ProductService;
import com.fresher.web.service.RatingService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	public static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/show")
	public List<Product> retrieveAllProducts() {
		return productService.findAll();
	}
	@GetMapping("/show/{artist_id}/{star}/{price_min}/{price_max}")
	public List<Product> retrieveAllProductsByQuery( @PathVariable int artist_id,  @PathVariable int star, @PathVariable int price_min, @PathVariable int price_max) {
		String artist_query ="";
		if(artist_id != 0) {
			artist_query = "artist_id = " + artist_id;
		}
		String query =" where " + artist_query+ " and avg_stars >= " + star + " and price >= " + price_min + " and price <= " + price_max;
		
		return productService.findAllProductsByQuery(query);
	}
	
	
	@GetMapping("/show/{id}")
	public Product retrieveProduct(@PathVariable int id) throws Exception {
		Optional<Product> product = productService.findById(id);
		
		return product.get();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product savedProduct = productService.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable int id) {

		Optional<Product> productOptional = productService.findById(id);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		product.setId(id);
		
		productService.save(product);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteById(id);
	}
	
	@RequestMapping("/search/title/{title}")
    public List<Product> getFilteredTitle(@PathVariable String title) {
 
        return productService.findByTitle(title);
    }
	
	@RequestMapping("/search/price/{price}")
    public List<Product> getFilteredPrice(@PathVariable int price) {
 
        return productService.findByPrice(price);
    }

}
