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

import com.fresher.web.entity.Cart;
import com.fresher.web.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	public static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@GetMapping("/show")
	public List<Cart> retrieveAllCarts() {
		return cartService.findAll();
	}

	@GetMapping("/show/{id}")
	public Cart retrieveCart(@PathVariable int id) throws Exception {
		Optional<Cart> cart = cartService.findById(id);

		if (!cart.isPresent())
			throw new Exception("id-" + id);

		return cart.get();
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createCart(@RequestBody Cart cart) {
		Cart savedCart = cartService.save(cart);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCart.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCart(@RequestBody Cart cart, @PathVariable int id) {

		Optional<Cart> cartOptional = cartService.findById(id);

		if (!cartOptional.isPresent())
			return ResponseEntity.notFound().build();

		cart.setId(id);

		cartService.save(cart);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		cartService.deleteById(id);
	}
}
