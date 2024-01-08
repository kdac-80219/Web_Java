package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PatientDTO {

	@NotNull
	@JsonProperty(value="id" ,access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message = "Name required!!!")
	private String patName;
	@Email(message = "Invalid Email Format!!")
	private String email;

}
