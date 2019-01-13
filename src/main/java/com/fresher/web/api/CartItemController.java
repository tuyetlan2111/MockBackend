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

import com.fresher.web.entity.CartItem;
import com.fresher.web.service.CartItemService;

@RestController
@RequestMapping("/cartItem")
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemController {

	public static Logger logger = LoggerFactory.getLogger(CartItemController.class);

	@Autowired
	CartItemService cartItemService;

	@GetMapping("/show")
	public List<CartItem> retrieveAllCartItems() {
		return cartItemService.findAll();
	}

	@GetMapping("/show/{id}")
	public CartItem retrieveCartItem(@PathVariable int id) throws Exception {
		Optional<CartItem> cartItem = cartItemService.findById(id);

		if (!cartItem.isPresent())
			throw new Exception("id-" + id);

		return cartItem.get();
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createCartItem(@RequestBody CartItem cartItem) {
		CartItem savedCartItem = cartItemService.save(cartItem);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCartItem.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCartItem(@RequestBody CartItem cartItem, @PathVariable int id) {

		Optional<CartItem> cartItemOptional = cartItemService.findById(id);

		if (!cartItemOptional.isPresent())
			return ResponseEntity.notFound().build();

		cartItem.setId(id);

		cartItemService.save(cartItem);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteError(@PathVariable int id) {
		cartItemService.deleteById(id);
	}
}
