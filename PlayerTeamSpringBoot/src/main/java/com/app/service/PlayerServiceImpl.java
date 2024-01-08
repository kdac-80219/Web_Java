package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.dto.PlayerDTO;
import com.app.entities.Player;
import com.app.entities.Team;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerdao;
	
	@Autowired
	private TeamDao teamdao;
	
	@Autowired
	private ModelMapper mapper;
	
	public PlayerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addNewPlayer(Long teamId,PlayerDTO PlayerDTO) {
		Team team = teamdao.findById(teamId).orElseThrow();
		Player play = mapper.map(PlayerDTO, Player.class);
		play.setTeam(team);
		Player play2 = playerdao.save(play);
		mapper.map(play2,PlayerDTO.class);
		return "Player Added!!!";
	}
}
