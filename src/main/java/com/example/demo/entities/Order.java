package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.example.demo.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;
	
	public Order() {
		
	}

	public Order(Long _id, Instant _moment, OrderStatus _orderStatus, User _customer) {
		super();
		this.id = _id;
		this.moment = _moment;
		setOrderStatus(_orderStatus);
		this.customer = _customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null)
		{
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.ValueOf(orderStatus);
	}
	
	public void setCustomer(User customer)
	{
		this.customer = customer;
	}
	
	public User getCustomer()
	{
		return customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
