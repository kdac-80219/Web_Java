package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerDTO {

	@JsonProperty(value = "teamId",access=Access.READ_ONLY)
	private Long teamId;
	private String firstName;
	private String lastName;
	private int age;
	private double battingAverage;
	@NotNull
	private int wickets;
	@NotNull
	private LocalDate birthDate;
	
}
