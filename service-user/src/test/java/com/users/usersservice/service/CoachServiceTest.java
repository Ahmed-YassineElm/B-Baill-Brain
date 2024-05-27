package com.users.usersservice.service;

import com.users.usersservice.model.Coach;
import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.repository.CoachRepository;
import com.users.usersservice.service.CoachService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoachServiceTest {

    @Mock
    private CoachRepository coachRepository;

    @InjectMocks
    private CoachService coachService;

    private Coach coach;

    @BeforeEach
    void setUp() {
        coach = new Coach();
        coach.setId(1L);
        coach.setFirstName("John Doe");
    }

    @Test
    void saveCoach() {
        when(coachRepository.save(any(Coach.class))).thenReturn(coach);

        Coach savedCoach = coachService.saveCoach(coach);

        assertNotNull(savedCoach);
        assertEquals(coach.getFirstName(), savedCoach.getFirstName());
        verify(coachRepository, times(1)).save(coach);
    }

    @Test
    void findAllCoaches() {
        List<Coach> coaches = Arrays.asList(coach, new Coach());
        when(coachRepository.findAll()).thenReturn(coaches);

        List<Coach> foundCoaches = coachService.findAllCoaches();

        assertEquals(2, foundCoaches.size());
        verify(coachRepository, times(1)).findAll();
    }

    @Test
    void findCoachById() {
        when(coachRepository.findById(anyLong())).thenReturn(Optional.of(coach));

        Optional<Coach> foundCoach = coachService.findCoachById(1L);

        assertTrue(foundCoach.isPresent());
        assertEquals(coach.getFirstName(), foundCoach.get().getFirstName());
        verify(coachRepository, times(1)).findById(1L);
    }

    @Test
    void deleteCoach() {
        doNothing().when(coachRepository).deleteById(anyLong());

        coachService.deleteCoach(1L);

        verify(coachRepository, times(1)).deleteById(1L);
    }
}
