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

import com.fresher.web.entity.User;
import com.fresher.web.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/show")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/show/{id}")
	public User retrieveUser(@PathVariable int id) throws Exception {
		Optional<User> user = userService.findById(id);

		if (!user.isPresent())
			throw new Exception("id-" + id);

		return user.get();
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id) {

		Optional<User> userOptional = userService.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);

		userService.save(user);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		userService.deleteById(id);
	}

	@PostMapping("/login")
	public User login(String email, String password) throws Exception {
		List<User> user = userService.findAll();
		for (User u : user) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				System.out.println("Success !!!");
			} else {
				System.out.println("Fail !!!");
			}
			return u;
		}
		return null;
	}
}
