package com.example.demo.entities;

import java.util.Date;

public class Payment {
	private Long id;
	private Date moment;
	
	public Payment() {
		super();
	}

	public Payment(Long id, Date moment) {
		super();
		this.id = id;
		this.moment = moment;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", moment=" + moment + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	
}
