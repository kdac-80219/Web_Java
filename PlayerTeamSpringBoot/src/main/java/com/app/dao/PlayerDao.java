package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Player;

public interface PlayerDao extends JpaRepository<Player, Long> {

}
