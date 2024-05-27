package com.users.usersservice.service;


import com.users.usersservice.model.Admin;
import com.users.usersservice.model.Coach;
import com.users.usersservice.model.Player;
import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    public Utilisateur getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Utilisateur saveUser(Utilisateur user) {
//        if (user instanceof Player) {
//            user.setRole("PLAYER");
//        } else if (user instanceof Coach) {
//            user.setRole("COACH");
//        } else if (user instanceof Admin) {
//            user.setRole("ADMIN");
//        } else {
//            throw new IllegalArgumentException("Invalid user type");
//        }
        if (user.getDateOfBirth() == null) {
            user.setDateOfBirth(LocalDate.now());
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String determineUserRole(Utilisateur user) {
        if (user instanceof Player) {
            return "PLAYER";
        } else if (user instanceof Coach) {
            return "COACH";
        } else if (user instanceof Admin) {
            return "ADMIN";
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}

