package com.ghacham.basketball.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return teamOptional.orElse(null);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }



    public Team updateTeam(Long teamId, Team teamDetails) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (!teamOptional.isPresent()) {
            return null;
        }

        Team team = teamOptional.get();
        team.setTeamName(teamDetails.getTeamName());
        team.setCity(teamDetails.getCity());

        return teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    public boolean existsById(Long teamId) {
        return teamRepository.existsById(teamId);
    }
}
