package com.ghacham.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
	
}
