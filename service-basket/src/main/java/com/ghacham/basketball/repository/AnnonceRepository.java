package com.ghacham.basketball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Announcement;


@Repository
public interface AnnonceRepository extends JpaRepository<Announcement, Long> {
    // Méthodes personnalisées si nécessaire
}
