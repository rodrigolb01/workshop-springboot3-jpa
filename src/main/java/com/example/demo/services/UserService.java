package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

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
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj)
	{
		return userRepository.save(obj);
	}
	
	public void delete(Long id)
	{
		try
		{
			userRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(long id, User obj)
	{
		try
		{
			User existingUser = userRepository.getReferenceById(id);
			updateData(existingUser, obj);
			return userRepository.save(existingUser);
		}
		catch(Exception e)
		{
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(User existingUser, User updated)
	{
		existingUser.setName(updated.getName());
		existingUser.setEmail(updated.getEmail());
		existingUser.setPhone(updated.getPhone());
	}
}
