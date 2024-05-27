package com.ghacham.basketball.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;

    @Column(name = "coach_name") // Mapping to the column "coach_name" in the database
    private String coachName;

    @Column(name = "coach_age") // Mapping to the column "coach_age" in the database
    private int coachAge;

    @JsonBackReference("team-coach")
    @OneToOne
    private Team team;

    // Getters and setters
    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getCoachAge() {
        return coachAge;
    }

    public void setCoachAge(int coachAge) {
        this.coachAge = coachAge;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team=team;
}
}