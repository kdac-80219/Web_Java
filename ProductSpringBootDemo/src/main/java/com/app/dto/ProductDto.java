package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
	@NotNull(message="CategoryID required!!!!")
	@JsonProperty(value="product_id",access =Access.READ_ONLY )
	private Long id;
	@NotBlank(message="Name is required!!!!")
	private String name;
	@NotBlank
	private String description;
	@NotNull
	private double price;
	private int availableStock;
	private LocalDate expiryDate;
	
}
