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

import com.fresher.web.entity.Payment;
import com.fresher.web.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
public static Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/show")
	public List<Payment> retrieveAllPayments() {
		return paymentService.findAll();
	}
	
	@GetMapping("/show/{id}")
	public Payment retrieveProduct(@PathVariable int id) throws Exception {
		Optional<Payment> payment = paymentService.findById(id);

		if (!payment.isPresent())
			throw new Exception("id-" + id);

		return payment.get();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createPayment(@RequestBody Payment payment) {
		Payment savedPayment = paymentService.save(payment);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPayment.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updatePayment(@RequestBody Payment payment, @PathVariable int id) {

		Optional<Payment> productOptional = paymentService.findById(id);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		payment.setId(id);
		
		paymentService.save(payment);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		paymentService.deleteById(id);
	}
}
