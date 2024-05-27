package com.users.usersservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void getRole() {
        Admin admin = new Admin();
        admin.setRole("ADMIN");

        assertEquals("ADMIN", admin.getRole());
    }

    @Test
    void getDepartment() {
        Admin admin = new Admin();
        admin.setDepartment("HR");

        assertEquals("HR", admin.getDepartment());
    }

    @Test
    void setRole() {
        Admin admin = new Admin();
        admin.setRole("ADMIN");

        assertEquals("ADMIN", admin.getRole());
    }

    @Test
    void setDepartment() {
        Admin admin = new Admin();
        admin.setDepartment("HR");

        assertEquals("HR", admin.getDepartment());
    }

    @Test
    void testEquals() {
        Admin admin1 = new Admin();
        admin1.setId(1L);
        admin1.setFirstName("John");
        admin1.setLastName("Doe");
        admin1.setUsername("johndoe");
        admin1.setPassword("password");
        admin1.setEmail("john.doe@example.com");
        admin1.setRole("ADMIN");
        admin1.setDepartment("HR");

        Admin admin2 = new Admin();
        admin2.setId(2L);
        admin2.setFirstName("Jane");
        admin2.setLastName("Doe");
        admin2.setUsername("janedoe");
        admin2.setPassword("password");
        admin2.setEmail("jane.doe@example.com");
        admin2.setRole("ADMIN");
        admin2.setDepartment("HR");

        Admin admin3 = new Admin();
        admin3.setId(1L);
        admin3.setFirstName("John");
        admin3.setLastName("Doe");
        admin3.setUsername("johndoe");
        admin3.setPassword("password");
        admin3.setEmail("john.doe@example.com");
        admin3.setRole("ADMIN");
        admin3.setDepartment("HR");

        assertEquals(admin1, admin3);
        assertNotEquals(admin1, admin2);
    }

    @Test
    void canEqual() {
        Admin admin1 = new Admin();
        admin1.setId(1L);
        admin1.setFirstName("John");
        admin1.setLastName("Doe");
        admin1.setUsername("johndoe");
        admin1.setPassword("password");
        admin1.setEmail("john.doe@example.com");
        admin1.setRole("ADMIN");
        admin1.setDepartment("HR");

        Admin admin2 = new Admin();
        admin2.setId(1L);
        admin2.setFirstName("John");
        admin2.setLastName("Doe");
        admin2.setUsername("johndoe");
        admin2.setPassword("password");
        admin2.setEmail("john.doe@example.com");
        admin2.setRole("ADMIN");
        admin2.setDepartment("HR");

        assertTrue(admin1.canEqual(admin2));
    }

    @Test
    void testHashCode() {
        Admin admin1 = new Admin();
        admin1.setId(1L);
        admin1.setFirstName("John");
        admin1.setLastName("Doe");
        admin1.setUsername("johndoe");
        admin1.setPassword("password");
        admin1.setEmail("john.doe@example.com");
        admin1.setRole("ADMIN");
        admin1.setDepartment("HR");

        Admin admin2 = new Admin();
        admin2.setId(1L);
        admin2.setFirstName("John");
        admin2.setLastName("Doe");
        admin2.setUsername("johndoe");
        admin2.setPassword("password");
        admin2.setEmail("john.doe@example.com");
        admin2.setRole("ADMIN");
        admin2.setDepartment("HR");

        assertEquals(admin1.hashCode(), admin2.hashCode());
    }


}
