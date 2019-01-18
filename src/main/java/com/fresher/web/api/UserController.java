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

import com.fresher.web.entity.User;
import com.fresher.web.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
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
	@GetMapping("/login/{email}/{password}")
	public User retrieveUser(@PathVariable String email, @PathVariable String password) throws Exception {
		User user = userService.findByEmailAndPassword(email, password);
		
		return user;
	}
	@GetMapping("/password/{email}/{old_password}/{password}")
	public User registerUser(@PathVariable String email,@PathVariable String old_password, @PathVariable String password) throws Exception {
		User user = userService.findByEmailAndPassword(email, old_password);
		if(user!=null) {
			user.setPassword(password);
			user = userService.save(user);
		}

		return user;
	}
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:4200")
	public User createUser(@RequestBody User user) {
		User savedUser = userService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return savedUser;

	}

	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
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
