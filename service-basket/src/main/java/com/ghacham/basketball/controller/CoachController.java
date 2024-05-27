package com.ghacham.basketball.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.entities.Coach;
import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.services.CoachService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @PostMapping
    public Coach createCoach(@RequestBody Coach coach) {
        return coachService.createCoach(coach);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        Optional<Coach> coach = coachService.getCoachById(id);
        return coach.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	// Endpoint pour ajouter un coach
	@PostMapping("/add")
	public ResponseEntity<Coach> addCoach(@RequestBody Coach coach) {
	        Coach savedCoach = coachService.addCoach(coach);
	        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
	}

 // Endpoint pour mettre à jour un coach
    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        Coach updatedCoach = coachService.updateCoach(id, coachDetails);
        return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
    }

    
    // Endpoint pour supprimer un coach par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoachById(@PathVariable Long id) {
        coachService.deleteCoachById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /*
    @PostMapping("/{coachId}/invite")
    public ResponseEntity<Coach> sendInvitationToPlayer(@PathVariable Long coachId, @RequestBody Player player) {
        Coach updatedCoach = coachService.sendInvitationToPlayer(coachId, player);
        if (updatedCoach != null) {
            return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{coachId}/invite/{playerId}")
    public ResponseEntity<Coach> removeInvitationFromPlayer(@PathVariable Long coachId, @PathVariable Long playerId) {
        Coach updatedCoach = coachService.removeInvitationFromPlayer(coachId, playerId);
        if (updatedCoach != null) {
            return new ResponseEntity<>(updatedCoach, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } */

    // Autres méthodes pour la mise à jour, la suppression, etc.
}
