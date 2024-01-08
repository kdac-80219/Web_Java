package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="team")
@Getter
@Setter
@ToString
public class Team extends BaseEntity{
	@Column(name="team_name",length=50)
	private String teamName;
	@Column(name="owner",length=50)
	private String owner;
	

	public Team() {
		super();
	}
	
	public Team(String teamName, String owner) {
		super();
		this.teamName = teamName;
		this.owner = owner;
	}
	
}
