package com.app.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDto {

	@JsonProperty(value="cat_id" ,access=Access.READ_ONLY)
	private Long id;
	private String name;
	private String description;
	
	
	
	
}
