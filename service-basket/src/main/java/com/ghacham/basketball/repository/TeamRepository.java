package com.ghacham.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Ajoutez des méthodes spécifiques si 

}
