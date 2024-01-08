package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TeamDao;
import com.app.dto.TeamDTO;
import com.app.entities.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao tdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addNewTeam(Team team) {
		String msg = "Team not addedd!!";
		
		tdao.save(team);
		msg="Team addedd!";
		return msg;
	}
	
}
