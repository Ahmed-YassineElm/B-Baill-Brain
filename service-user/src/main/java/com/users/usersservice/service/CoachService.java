package com.users.usersservice.service;

import com.users.usersservice.model.Coach;
import com.users.usersservice.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public List<Coach> findAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> findCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}
