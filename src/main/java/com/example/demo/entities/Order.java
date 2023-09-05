package com.example.demo.entities;

import java.util.Date;

import com.example.demo.enums.OrderStatus;

public class Order {
	private Long id;
	private Date Moment;
	private OrderStatus status;
	
	public Order() {
		super();
	}

	public Order(Long id, Date moment, OrderStatus status) {
		super();
		this.id = id;
		Moment = moment;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMoment() {
		return Moment;
	}

	public void setMoment(Date moment) {
		Moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
