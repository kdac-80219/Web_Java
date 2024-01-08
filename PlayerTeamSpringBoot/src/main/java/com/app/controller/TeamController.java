package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TeamDTO;
import com.app.entities.Team;
import com.app.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

	public TeamController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private TeamService ts;
	
	@PostMapping("/add")
	public String addTeam(@RequestBody Team team)
	{
		return ts.addNewTeam(team);
	}
}
