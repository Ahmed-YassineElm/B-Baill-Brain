package com.users.usersservice.service;


import com.users.usersservice.model.Player;
import com.users.usersservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

