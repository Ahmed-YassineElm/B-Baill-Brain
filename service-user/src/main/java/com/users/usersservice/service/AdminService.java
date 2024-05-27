package com.users.usersservice.service;

import com.users.usersservice.model.Admin;
import com.users.usersservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
