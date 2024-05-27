package com.ghacham.basketball.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ghacham.basketball.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
    Utilisateur findByEmail(String email);
    // Ajoutez des méthodes spécifiques si nécessaire
	
}
