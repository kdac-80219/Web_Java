package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DoctorDTO {

	@NotNull
	@JsonProperty(value="doctor_id" ,access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message = "Name is required!!!!!")
	private String doctorName;
	@Email(message = "Invalid Email Format!!!")
	private String email;
}
