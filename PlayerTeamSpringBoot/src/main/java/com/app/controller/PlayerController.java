package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.dto.PlayerDTO;
import com.app.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerservice;
	
	
	public PlayerController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add/{teamId}")
	public String addPlayer(@PathVariable Long teamId,@RequestBody PlayerDTO playerdto)
	{
		return playerservice.addNewPlayer(teamId,playerdto);
	}
	
	@PostMapping("/{playerId}")
	public String deletePlayer(@PathVariable Long playerId)
	{
		
	}
	
}
