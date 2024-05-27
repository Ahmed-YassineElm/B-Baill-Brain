package com.users.usersservice.controller;

import com.users.usersservice.model.Admin;
import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.findAllAdmins();
        return ResponseEntity.ok(admins);
    }




}