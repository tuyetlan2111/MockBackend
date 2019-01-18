package com.fresher.web.api;

import java.net.URI;
import java.util.ArrayList;
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
import com.fresher.web.entity.CartItem;
import com.fresher.web.service.CartItemService;
import com.fresher.web.service.CartService;

@RestController
@RequestMapping("/cartItem")
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemController {

	public static Logger logger = LoggerFactory.getLogger(CartItemController.class);

	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	CartService cartService;

	@GetMapping("/show")
	public List<CartItem> retrieveAllCartItems() {
		return cartItemService.findAll();
	}

	@GetMapping("/show/{cookie}")
	public List<CartItem> retrieveCartItem(@PathVariable String cookie) throws Exception {
		Cart cart = cartService.findByCookie(cookie);
		List<CartItem> cartItems = new ArrayList<>();
		if(cart!= null) {
			cartItems = cartItemService.findByCartId(cart.getId());
		}
		return cartItems;
	}
	@PostMapping("/create")
	public ResponseEntity<Object> createCartItem(@RequestBody CartItem cartItem) {
		CartItem savedCartItem = cartItemService.save(cartItem);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCartItem.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@PostMapping("/check-set-cart-item")
	public CartItem checkSetCartItem(@RequestBody CartItem cartItem) {
		CartItem newCartItem = cartItemService.findByProductIdAndCartId(cartItem.getProduct().getId(),cartItem.getCart().getId());
		if(newCartItem == null) {
			newCartItem = cartItemService.save(cartItem);
		}else {
			int num = cartItem.getQuantity() + newCartItem.getQuantity();
			newCartItem.setQuantity(num);
			newCartItem = cartItemService.save(newCartItem);
		}

		return cartItem;

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
