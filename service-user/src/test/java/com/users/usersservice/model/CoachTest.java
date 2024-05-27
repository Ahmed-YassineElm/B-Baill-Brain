package com.users.usersservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    @Test
    void testEquals() {
        Coach coach1 = new Coach();
        coach1.setId(1L);
        coach1.setFirstName("John");
        coach1.setLastName("Doe");
        coach1.setUsername("johndoe");
        coach1.setPassword("password");
        coach1.setEmail("john.doe@example.com");
        coach1.setRole("COACH");
        coach1.setTeamId(123L);
        coach1.setExperienceYears(5);

        Coach coach2 = new Coach();
        coach2.setId(1L);
        coach2.setFirstName("John");
        coach2.setLastName("Doe");
        coach2.setUsername("johndoe");
        coach2.setPassword("password");
        coach2.setEmail("john.doe@example.com");
        coach2.setRole("COACH");
        coach2.setTeamId(123L);
        coach2.setExperienceYears(5);

        Coach coach3 = new Coach();
        coach3.setId(2L);
        coach3.setFirstName("Jane");
        coach3.setLastName("Smith");
        coach3.setUsername("janesmith");
        coach3.setPassword("password");
        coach3.setEmail("jane.smith@example.com");
        coach3.setRole("COACH");
        coach3.setTeamId(456L);
        coach3.setExperienceYears(10);

        assertTrue(coach1.equals(coach2));
        assertFalse(coach1.equals(coach3));
    }

    @Test
    void testHashCode() {
        Coach coach1 = new Coach();
        coach1.setId(1L);
        coach1.setFirstName("John");
        coach1.setLastName("Doe");
        coach1.setUsername("johndoe");
        coach1.setPassword("password");
        coach1.setEmail("john.doe@example.com");
        coach1.setRole("COACH");
        coach1.setTeamId(123L);
        coach1.setExperienceYears(5);

        Coach coach2 = new Coach();
        coach2.setId(1L);
        coach2.setFirstName("John");
        coach2.setLastName("Doe");
        coach2.setUsername("johndoe");
        coach2.setPassword("password");
        coach2.setEmail("john.doe@example.com");
        coach2.setRole("COACH");
        coach2.setTeamId(123L);
        coach2.setExperienceYears(5);

        Coach coach3 = new Coach();
        coach3.setId(2L);
        coach3.setFirstName("Jane");
        coach3.setLastName("Smith");
        coach3.setUsername("janesmith");
        coach3.setPassword("password");
        coach3.setEmail("jane.smith@example.com");
        coach3.setRole("COACH");
        coach3.setTeamId(456L);
        coach3.setExperienceYears(10);

        assertEquals(coach1.hashCode(), coach2.hashCode());
        assertNotEquals(coach1.hashCode(), coach3.hashCode());
    }

    @Test
    void getTeamId() {
        Long teamId = 123L;
        Coach coach = new Coach();
        coach.setTeamId(teamId);
        assertEquals(teamId, coach.getTeamId());
    }

    @Test
    void getExperienceYears() {
        int experienceYears = 5;
        Coach coach = new Coach();
        coach.setExperienceYears(experienceYears);
        assertEquals(experienceYears, coach.getExperienceYears());
    }

    @Test
    void setTeamId() {
        Long teamId = 456L;
        Coach coach = new Coach();
        coach.setTeamId(teamId);
        assertEquals(teamId, coach.getTeamId());
    }

    @Test
    void setExperienceYears() {
        int experienceYears = 10;
        Coach coach = new Coach();
        coach.setExperienceYears(experienceYears);
        assertEquals(experienceYears, coach.getExperienceYears());
    }


}
