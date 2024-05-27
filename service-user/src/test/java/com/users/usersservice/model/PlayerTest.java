package com.users.usersservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testEquals() {
        Player player1 = new Player();
        player1.setId(1L);
        player1.setFirstName("John");
        player1.setLastName("Doe");
        player1.setUsername("johndoe");
        player1.setPassword("password");
        player1.setEmail("john.doe@example.com");
        player1.setRole("PLAYER");
        player1.setPosition("Forward");
        player1.setJerseyNumber(10);

        Player player2 = new Player();
        player2.setId(1L);
        player2.setFirstName("John");
        player2.setLastName("Doe");
        player2.setUsername("johndoe");
        player2.setPassword("password");
        player2.setEmail("john.doe@example.com");
        player2.setRole("PLAYER");
        player2.setPosition("Forward");
        player2.setJerseyNumber(10);

        Player player3 = new Player();
        player3.setId(2L);
        player3.setFirstName("Jane");
        player3.setLastName("Smith");
        player3.setUsername("janesmith");
        player3.setPassword("password");
        player3.setEmail("jane.smith@example.com");
        player3.setRole("PLAYER");
        player3.setPosition("Guard");
        player3.setJerseyNumber(5);

        assertTrue(player1.equals(player2));
        assertFalse(player1.equals(player3));
    }

    @Test
    void testHashCode() {
        Player player1 = new Player();
        player1.setId(1L);
        player1.setFirstName("John");
        player1.setLastName("Doe");
        player1.setUsername("johndoe");
        player1.setPassword("password");
        player1.setEmail("john.doe@example.com");
        player1.setRole("PLAYER");
        player1.setPosition("Forward");
        player1.setJerseyNumber(10);

        Player player2 = new Player();
        player2.setId(1L);
        player2.setFirstName("John");
        player2.setLastName("Doe");
        player2.setUsername("johndoe");
        player2.setPassword("password");
        player2.setEmail("john.doe@example.com");
        player2.setRole("PLAYER");
        player2.setPosition("Forward");
        player2.setJerseyNumber(10);

        Player player3 = new Player();
        player3.setId(2L);
        player3.setFirstName("Jane");
        player3.setLastName("Smith");
        player3.setUsername("janesmith");
        player3.setPassword("password");
        player3.setEmail("jane.smith@example.com");
        player3.setRole("PLAYER");
        player3.setPosition("Guard");
        player3.setJerseyNumber(5);

        assertEquals(player1.hashCode(), player2.hashCode());
        assertNotEquals(player1.hashCode(), player3.hashCode());
    }

    @Test
    void getPosition() {
        String position = "Forward";
        Player player = new Player();
        player.setPosition(position);
        assertEquals(position, player.getPosition());
    }

    @Test
    void getJerseyNumber() {
        int jerseyNumber = 10;
        Player player = new Player();
        player.setJerseyNumber(jerseyNumber);
        assertEquals(jerseyNumber, player.getJerseyNumber());
    }

    @Test
    void setPosition() {
        String position = "Guard";
        Player player = new Player();
        player.setPosition(position);
        assertEquals(position, player.getPosition());
    }

    @Test
    void setJerseyNumber() {
        int jerseyNumber = 5;
        Player player = new Player();
        player.setJerseyNumber(jerseyNumber);
        assertEquals(jerseyNumber, player.getJerseyNumber());
    }

    @Test
    void testToString() {
        Player player = new Player();
        player.setId(1L);
        player.setFirstName("John");
        player.setLastName("Doe");
        player.setUsername("johndoe");
        player.setPassword("password");
        player.setEmail("john.doe@example.com");
        player.setRole("PLAYER");
        player.setPosition("Forward");
        player.setJerseyNumber(10);

        String expectedToString = "Player{id=1, firstName='John', lastName='Doe', username='johndoe', " +
                "password='password', email='john.doe@example.com', dateOfBirth=null, role='PLAYER', " +
                "position='Forward', jerseyNumber=10}";
        assertEquals(expectedToString, player.toString());
    }
}
