package com.users.usersservice.service;

import com.users.usersservice.model.Admin;
import com.users.usersservice.model.Coach;
import com.users.usersservice.model.Player;
import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.repository.UserRepository;
import com.users.usersservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<Utilisateur> mockUsers = Arrays.asList(new Player(), new Coach(), new Admin());
        when(userRepository.findAll()).thenReturn(mockUsers);

        List<Utilisateur> result = userService.getAllUsers();

        assertEquals(3, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        Utilisateur mockUser = new Player();
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        Utilisateur result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(mockUser, result);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Utilisateur result = userService.getUserById(1L);

        assertNull(result);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveUser() {
        Utilisateur mockUser = new Player();
        when(userRepository.save(any(Utilisateur.class))).thenReturn(mockUser);

        Utilisateur result = userService.saveUser(mockUser);

        assertNotNull(result);
        assertEquals(mockUser, result);
        verify(userRepository, times(1)).save(mockUser);
    }

    @Test
    void testSaveUser_SetDateOfBirth() {
        Utilisateur mockUser = new Player();
        mockUser.setDateOfBirth(null);
        when(userRepository.save(any(Utilisateur.class))).thenAnswer(i -> i.getArguments()[0]);

        Utilisateur result = userService.saveUser(mockUser);

        assertNotNull(result.getDateOfBirth());
        assertEquals(LocalDate.now(), result.getDateOfBirth());
        verify(userRepository, times(1)).save(mockUser);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDetermineUserRole_Player() {
        Player player = new Player();
        String role = userService.determineUserRole(player);

        assertEquals("PLAYER", role);
    }

    @Test
    void testDetermineUserRole_Coach() {
        Coach coach = new Coach();
        String role = userService.determineUserRole(coach);

        assertEquals("COACH", role);
    }

    @Test
    void testDetermineUserRole_Admin() {
        Admin admin = new Admin();
        String role = userService.determineUserRole(admin);

        assertEquals("ADMIN", role);
    }

    @Test
    void testDetermineUserRole_Invalid() {
        Utilisateur invalidUser = new Utilisateur() {}; // Anonymous class
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.determineUserRole(invalidUser);
        });

        assertEquals("Invalid user type", exception.getMessage());
    }
}
