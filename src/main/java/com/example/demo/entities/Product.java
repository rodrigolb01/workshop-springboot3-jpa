package com.example.demo.entities;

public class Product {
	private Long id;
	private String name;
	private String description;
	private Double value; 
	private String imgUrl;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String description, Double value, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", imgUrl=" + imgUrl + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
