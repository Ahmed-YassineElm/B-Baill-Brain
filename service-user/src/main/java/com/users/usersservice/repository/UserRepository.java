package com.users.usersservice.repository;

import com.users.usersservice.model.Utilisateur;
import com.users.usersservice.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
}
