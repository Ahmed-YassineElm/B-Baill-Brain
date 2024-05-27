package com.ghacham.basketball.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Coach;
import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    
    // Méthode pour récupérer un coach par son ID
    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }
    
 // Méthode pour ajouter un coach
    public Coach addCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    // Méthode pour mettre à jour un coach
    public Coach updateCoach(Long id, Coach coachDetails) {
        Coach coach = coachRepository.findById(id)
                                      .orElseThrow();
        coach.setCoachName(coachDetails.getCoachName());
        coach.setCoachAge(coachDetails.getCoachAge());
        coach.setTeam(coachDetails.getTeam());
        return coachRepository.save(coach);
    }
    
    // Méthode pour supprimer un coach par son ID
    public void deleteCoachById(Long id) {
        coachRepository.deleteById(id);
    }
    
    /*
    public Coach sendInvitationToPlayer(Long coachId, Player player) {
        Coach coach = coachRepository.findById(coachId).orElse(null);
        if (coach != null) {
            // Ajouter le joueur à la liste des joueurs invités par le coach
            coach.getInvitedPlayers().add(player);
            // Mettre à jour le coach dans la base de données
            return coachRepository.save(coach);
        }
        return null;
    }

    public Coach removeInvitationFromPlayer(Long coachId, Long playerId) {
        Coach coach = coachRepository.findById(coachId).orElse(null);
        if (coach != null) {
            // Retirer le joueur de la liste des joueurs invités par le coach
            coach.getInvitedPlayers().removeIf(player -> player.getPlayerId().equals(playerId));
            // Mettre à jour le coach dans la base de données
            return coachRepository.save(coach);
        }
        return null;
    }*/


    // Autres méthodes pour la mise à jour, la suppression, etc.
}
