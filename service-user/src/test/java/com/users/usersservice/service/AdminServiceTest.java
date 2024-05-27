package com.users.usersservice.service;

import com.users.usersservice.model.Admin;
import com.users.usersservice.repository.AdminRepository;
import com.users.usersservice.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    private Admin admin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        admin = new Admin();
        admin.setId(1L);
        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setUsername("adminuser");
        admin.setPassword("password");
        admin.setEmail("admin.user@example.com");
        admin.setRole("ADMIN");
        admin.setDepartment("IT");
    }

    @Test
    void saveAdmin() {
        // Arrange
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        // Act
        Admin savedAdmin = adminService.saveAdmin(admin);

        // Assert
        assertNotNull(savedAdmin);
        assertEquals(admin.getUsername(), savedAdmin.getUsername());
        verify(adminRepository, times(1)).save(admin);
    }

    @Test
    void findAllAdmins() {
        // Arrange
        List<Admin> admins = new ArrayList<>();
        admins.add(admin);
        when(adminRepository.findAll()).thenReturn(admins);

        // Act
        List<Admin> foundAdmins = adminService.findAllAdmins();

        // Assert
        assertNotNull(foundAdmins);
        assertEquals(1, foundAdmins.size());
        verify(adminRepository, times(1)).findAll();
    }

    @Test
    void findAdminById() {
        // Arrange
        Long adminId = 1L;
        when(adminRepository.findById(adminId)).thenReturn(Optional.of(admin));

        // Act
        Optional<Admin> foundAdmin = adminService.findAdminById(adminId);

        // Assert
        assertTrue(foundAdmin.isPresent());
        assertEquals(admin.getUsername(), foundAdmin.get().getUsername());
        verify(adminRepository, times(1)).findById(adminId);
    }

    @Test
    void deleteAdmin() {
        // Arrange
        Long adminId = 1L;

        // Act
        adminService.deleteAdmin(adminId);

        // Assert
        verify(adminRepository, times(1)).deleteById(adminId);
    }
}
