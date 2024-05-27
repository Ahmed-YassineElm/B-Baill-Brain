package com.users.usersservice.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach extends Utilisateur {
    private Long teamId;
    private int experienceYears;
}

