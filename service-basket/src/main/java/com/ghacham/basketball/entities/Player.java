package com.ghacham.basketball.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;

	@Column(name = "player_name") // Mapping to the column "player_name" in the database
	private String playerName;

	@JsonBackReference("team-player")
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	@JsonBackReference("coach-player")
	@ManyToOne
	@JoinColumn(name = "coach_id")
	private Coach coach;

	// Getters and setters
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach =coach;
	}
}
