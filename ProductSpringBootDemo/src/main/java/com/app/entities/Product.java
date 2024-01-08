package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product extends BaseEntity {
	
	@Column(name="product_name",length=20)
	private String name;
	@Column(name="description",length=50)
	private String description;
	private double price;
	@ManyToOne
	@JoinColumn(name="category_id" ,nullable = false)
	private Category prodCategory;
	@Column(name="available_stock")
	private int availableStock;
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	
	
	public Product() {
		super();
	}


	public Product(String name, String description, double price, Category prodCategory, int availableStock,
			LocalDate expiryDate) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.prodCategory = prodCategory;
		this.availableStock = availableStock;
		this.expiryDate = expiryDate;
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Category getProdCategory() {
		return prodCategory;
	}


	public void setProdCategory(Category prodCategory) {
		this.prodCategory = prodCategory;
	}


	public int getAvailableStock() {
		return availableStock;
	}


	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", prodCategory="
				+ prodCategory + ", availableStock=" + availableStock + ", expiryDate=" + expiryDate + "]";
	}
	
	
}
