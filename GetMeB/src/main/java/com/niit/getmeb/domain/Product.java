package com.niit.getmeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")
@Component
public class Product {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private int price;
	@Column(name="catgory_id")
	private String category_id;
	@Column(name="supplier_id")
	private String supplier_id;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category_id;
	}
	public void setCategory(String category_id) {
		this.category_id = category_id;
	}
	public String getSupplier() {
		return supplier_id;
	}
	public void setSupplier(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	
	
}
