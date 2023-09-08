package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public User findById(long id)
	{
		Optional<User> u = userRepository.findById(id);
		return u.get();
	}
	
	public User insert(User obj)
	{
		return userRepository.save(obj);
	}
}
