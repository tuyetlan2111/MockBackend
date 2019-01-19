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
import com.fresher.web.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
public static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/show")
	public List<Order> retrieveAllOrders() {
		return orderService.findAll();
	}
	
	@GetMapping("/show/{user_id}")
	public List<Order> retrieveProduct(@PathVariable int user_id) throws Exception {
		return orderService.findByUserId(user_id);

	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createOrder(@RequestBody Order order) {
		Order savedOrder = orderService.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody Order order, @PathVariable int id) {

		Optional<Order> productOptional = orderService.findById(id);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		order.setId(id);
		
		orderService.save(order);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		orderService.deleteById(id);
	}
}
