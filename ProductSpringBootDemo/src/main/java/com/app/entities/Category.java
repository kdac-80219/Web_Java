package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Setter
@Getter
public class Category extends BaseEntity{

	@Column(unique = true,length=50)
	private String name;
	@Column(unique = true,length=50)
	private String description;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
