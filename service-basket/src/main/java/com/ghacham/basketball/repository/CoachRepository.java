package com.ghacham.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Coach;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
