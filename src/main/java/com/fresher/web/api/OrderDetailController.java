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

import com.fresher.web.entity.OrderDetail;
import com.fresher.web.service.OrderDetailService;

@RestController
@RequestMapping("/orderDetail")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderDetailController {
	
public static Logger logger = LoggerFactory.getLogger(OrderDetailController.class);
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/show")
	public List<OrderDetail> retrieveAllOrders() {
		return orderDetailService.findAll();
	}
	
	@GetMapping("/show/{id}")
	public OrderDetail retrieveProduct(@PathVariable int id) throws Exception {
		Optional<OrderDetail> orderDetail = orderDetailService.findById(id);

		if (!orderDetail.isPresent())
			throw new Exception("id-" + id);

		return orderDetail.get();
	}
	@GetMapping("/show-user/{id}")
	public OrderDetail retrieveProductUser(@PathVariable int id) throws Exception {
		OrderDetail orderDetail = orderDetailService.findByUserId(id);

		return orderDetail;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createOrder(@RequestBody OrderDetail orderDetail) {
		OrderDetail savedOrderDetail = orderDetailService.save(orderDetail);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrderDetail.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody OrderDetail orderDetail, @PathVariable int id) {

		Optional<OrderDetail> orderDetailOptional = orderDetailService.findById(id);

		if (!orderDetailOptional.isPresent())
			return ResponseEntity.notFound().build();

		orderDetail.setId(id);
		
		orderDetailService.save(orderDetail);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		orderDetailService.deleteById(id);
	}
}