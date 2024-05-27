package com.ghacham.basketball.services;
import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.repository.TeamRepository;
import com.ghacham.basketball.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTeams() {
        // Mock data
        List<Team> teams = Arrays.asList(new Team(), new Team());
        when(teamRepository.findAll()).thenReturn(teams);

        // Call the method
        List<Team> result = teamService.getAllTeams();

        // Verify the result
        assertEquals(teams.size(), result.size());
    }

    @Test
    public void testGetTeamById() {
        // Mock data
        long teamId = 1L;
        Team team = new Team();
        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));

        // Call the method
        Team result = teamService.getTeamById(teamId);

        // Verify the result
        assertEquals(team, result);
    }

    // Add tests for other methods such as createTeam, updateTeam, deleteTeam, existsById, etc.
}
