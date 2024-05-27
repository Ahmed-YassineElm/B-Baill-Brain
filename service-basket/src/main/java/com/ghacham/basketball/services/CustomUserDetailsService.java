/*package com.ghacham.basketball.services;

import com.ghacham.basketball.entities.Utilisateur;
import com.ghacham.basketball.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
            .username(utilisateur.getUsername())
            .password(utilisateur.getPassword())
            .roles(utilisateur.getUserType().name())
            .build();
    }
}*/
