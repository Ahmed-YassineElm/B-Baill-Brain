package com.ghacham.basketball.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Autres méthodes pour la mise à jour, la suppression, etc.
}
