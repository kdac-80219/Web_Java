package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="player")
@Getter
@Setter
@ToString
public class Player extends BaseEntity{

	@Column(name="first_name",length=50)
	private String firstName;
	@Column(name="last_name",length=50)
	private String lastName;
	private int age;
	@Column(name="batting_avrg")
	private double battingAverage;
	@Column(name="wickets_taken")
	private int wickets;
	@Column(name="dob")
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name="team_id",nullable = false)
	private Team team;
	
	
	
	public Player() {
		super();
	}

	public Player(String firstName, String lastName, int age, double battingAverage, int wickets, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.battingAverage = battingAverage;
		this.wickets = wickets;
		this.birthDate = birthDate;
	}
	
	
}
