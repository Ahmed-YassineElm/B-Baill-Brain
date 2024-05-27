package com.ghacham.basketball.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Utilisateur;
import com.ghacham.basketball.repository.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

	
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    
    public Utilisateur findUserByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}
    
    /*@Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur createUser(Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }*/
    
    // Autres méthodes pour la mise à jour, la suppression, etc.
}
