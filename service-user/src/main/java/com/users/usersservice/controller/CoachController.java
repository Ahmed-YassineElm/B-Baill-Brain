package com.users.usersservice.controller;

import com.users.usersservice.model.Coach;
import com.users.usersservice.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach createdCoach = coachService.saveCoach(coach);
        return ResponseEntity.ok(createdCoach);
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachService.findAllCoaches();
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        return coachService.findCoachById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach updatedCoach) {
        return coachService.findCoachById(id)
                .map(existingCoach -> {
                    existingCoach.setExperienceYears(updatedCoach.getExperienceYears());
                    existingCoach.setTeamId(updatedCoach.getTeamId());
                    Coach savedCoach = coachService.saveCoach(existingCoach);
                    return ResponseEntity.ok(savedCoach);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
