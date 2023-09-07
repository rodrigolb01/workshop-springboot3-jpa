package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll()
	{
		return productRepository.findAll();
	}
	
	public Product findById(long id)
	{
		Optional<Product> u = productRepository.findById(id);
		return u.get();
	}
}