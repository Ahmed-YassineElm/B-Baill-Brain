package com.users.usersservice.service;

import com.users.usersservice.model.Player;
import com.users.usersservice.repository.PlayerRepository;
import com.users.usersservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player player;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        player = new Player();
        player.setId(1L);
        player.setFirstName("John");
        player.setLastName("Doe");
        player.setUsername("johndoe");
        player.setPassword("password");
        player.setEmail("john.doe@example.com");
        player.setDateOfBirth(LocalDate.of(1995, 5, 15));
    }

    @Test
    void savePlayer() {
        // Arrange
        when(playerRepository.save(any(Player.class))).thenReturn(player);

        // Act
        Player savedPlayer = playerService.savePlayer(player);

        // Assert
        assertNotNull(savedPlayer);
        assertEquals(player.getFirstName(), savedPlayer.getFirstName());
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    void findAllPlayers() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(player);

        when(playerRepository.findAll()).thenReturn(players);

        // Act
        List<Player> foundPlayers = playerService.findAllPlayers();

        // Assert
        assertNotNull(foundPlayers);
        assertEquals(1, foundPlayers.size());
        assertEquals(player.getFirstName(), foundPlayers.get(0).getFirstName());
        verify(playerRepository, times(1)).findAll();
    }

    @Test
    void findPlayerById() {
        // Arrange
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        // Act
        Optional<Player> foundPlayerOptional = playerService.findPlayerById(1L);

        // Assert
        assertNotNull(foundPlayerOptional);
        assertEquals(player.getFirstName(), foundPlayerOptional.get().getFirstName());
        verify(playerRepository, times(1)).findById(1L);
    }

    @Test
    void deletePlayer() {
        // Arrange
        Long playerId = 1L;

        // Act
        playerService.deletePlayer(playerId);

        // Assert
        verify(playerRepository, times(1)).deleteById(playerId);
    }
}
