package com.ghacham.basketball.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Schema;

@Repository
public interface SchemaRepository extends JpaRepository<Schema, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}

