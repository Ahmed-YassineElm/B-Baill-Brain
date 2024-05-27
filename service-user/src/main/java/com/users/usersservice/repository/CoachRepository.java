package com.users.usersservice.repository;


import com.users.usersservice.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}

