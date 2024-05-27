package com.users.usersservice.controller;


import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        Utilisateur user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur user) {
        if (user.getDateOfBirth() == null) {
            user.setDateOfBirth(LocalDate.now());
        }
        return ResponseEntity.ok(userService.saveUser(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/current")
    public ResponseEntity<List<Map<String, Object>>> getCurrentUsers() {
        Map<String, Object> user1 = new HashMap<>();
        user1.put("role", "COACH");
        user1.put("userID", 123L);

        List<Map<String, Object>> users = Arrays.asList(user1);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //functionnality for basketball service ********************************************************************
    @GetMapping("/{id}/role")
    public boolean getUserRole(@PathVariable Long id) {
        Utilisateur user = userService.getUserById(id);
        if (user == null) {
            return false;
        }

        String role = userService.determineUserRole(user);
        return true;
    }
}

