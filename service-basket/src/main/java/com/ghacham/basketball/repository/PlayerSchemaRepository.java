package com.ghacham.basketball.repository;

import com.ghacham.basketball.entities.PlayerSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSchemaRepository extends JpaRepository<PlayerSchema, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
