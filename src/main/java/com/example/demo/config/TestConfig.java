package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import com.example.demo.entities.Payment;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderItemRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "maria", "maria@gmail.com", "(44)8799-7833", "123456");
		User u2 = new User(null, "mario", "mario@gmail.com", "(44)9987-3378", "654321");
		
		Order o1 = new Order(null, Instant.parse("2023-08-23T19:00:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-09-25T20:00:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-09-25T20:00:00Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		Category c1 = new Category(null, "cosmetics");
		Category c2 = new Category(null, "medicine");
		
		Product p1 = new Product(null, "shapoo", "Keeps your hair healty", 08.99, "aawwwwwwaaswwwwsasdsadwsad");
		Product p2 = new Product(null, "cottom pads", "Nice and soft cottom pads for cleaning your ears", 02.99, "asdsadsadsdsad");
		
		p1.getCategories().add(c1);
		

	
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1,c2));
		productRepository.saveAll(Arrays.asList(p1,p2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

		Payment pay1 = new Payment(null, Instant.parse("2023-08-23T19:00:00Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
}
