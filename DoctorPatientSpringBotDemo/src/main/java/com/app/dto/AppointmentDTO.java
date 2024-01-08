package com.app.dto;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppointmentDTO {

	private Long patientId;
	private Long doctorId;
	private LocalDate date;
}
