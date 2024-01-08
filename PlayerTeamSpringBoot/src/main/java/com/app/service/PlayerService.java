package com.app.service;

import com.app.dto.PlayerDTO;

public interface PlayerService {

	String addNewPlayer(Long teamId,PlayerDTO playerdto);
}
