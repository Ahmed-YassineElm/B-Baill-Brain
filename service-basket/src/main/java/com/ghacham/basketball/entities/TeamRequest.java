package com.ghacham.basketball.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class TeamRequest {
    @JsonManagedReference
    private Team team;
    @JsonManagedReference
    private Long id;
}
