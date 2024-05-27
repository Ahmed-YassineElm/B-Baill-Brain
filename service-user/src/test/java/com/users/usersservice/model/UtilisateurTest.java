package com.users.usersservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {

    @Test
    void testEquals() {
        Utilisateur utilisateur1 = new Utilisateur(1L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");

        // Test with itself
        assertTrue(utilisateur1.equals(utilisateur1));

        // Test with an object that is equal
        Utilisateur utilisateur2 = new Utilisateur(1L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");
        assertTrue(utilisateur1.equals(utilisateur2));

        // Test with null
        assertFalse(utilisateur1.equals(null));

        // Test with different id
        Utilisateur utilisateur3 = new Utilisateur(2L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");
        assertFalse(utilisateur1.equals(utilisateur3));
    }

    @Test
    void testHashCode() {
        Utilisateur utilisateur1 = new Utilisateur(1L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");

        Utilisateur utilisateur2 = new Utilisateur(1L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");

        assertEquals(utilisateur1.hashCode(), utilisateur2.hashCode());

        Utilisateur utilisateur3 = new Utilisateur(2L, "John", "Doe", "johndoe", "password", "john.doe@example.com",
                LocalDate.of(1990, 1, 1), "USER");

        assertNotEquals(utilisateur1.hashCode(), utilisateur3.hashCode());
    }

    @Test
    void getId() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        assertEquals(1L, utilisateur.getId());
    }

    @Test
    void getFirstName() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setFirstName("John");
        assertEquals("John", utilisateur.getFirstName());
    }

    @Test
    void getLastName() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLastName("Doe");
        assertEquals("Doe", utilisateur.getLastName());
    }

    @Test
    void getUsername() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername("johndoe");
        assertEquals("johndoe", utilisateur.getUsername());
    }

    @Test
    void getPassword() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword("password");
        assertEquals("password", utilisateur.getPassword());
    }

    @Test
    void getEmail() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", utilisateur.getEmail());
    }

    @Test
    void getDateOfBirth() {
        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth, utilisateur.getDateOfBirth());
    }

    @Test
    void getRole() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setRole("USER");
        assertEquals("USER", utilisateur.getRole());
    }

    @Test
    void setId() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        assertEquals(1L, utilisateur.getId());
    }

    @Test
    void setFirstName() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setFirstName("John");
        assertEquals("John", utilisateur.getFirstName());
    }

    @Test
    void setLastName() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLastName("Doe");
        assertEquals("Doe", utilisateur.getLastName());
    }

    @Test
    void setUsername() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername("johndoe");
        assertEquals("johndoe", utilisateur.getUsername());
    }

    @Test
    void setPassword() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword("password");
        assertEquals("password", utilisateur.getPassword());
    }

    @Test
    void setEmail() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", utilisateur.getEmail());
    }

    @Test
    void setDateOfBirth() {
        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth, utilisateur.getDateOfBirth());
    }

    @Test
    void setRole() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setRole("USER");
        assertEquals("USER", utilisateur.getRole());
    }


}
