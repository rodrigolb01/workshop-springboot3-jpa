package com.example.resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll()
	{
		User u = new User(1L, "Joe Doe", "joedoe@gmail.com", "(44)9710-9924", "1234");
		return ResponseEntity.ok().body(u);
	}
}
