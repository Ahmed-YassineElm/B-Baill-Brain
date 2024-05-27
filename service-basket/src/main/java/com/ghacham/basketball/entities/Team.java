package com.ghacham.basketball.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;

	@Column(name = "team_name") // Mapping to the column "team_name" in the database
	private String teamName;

	@Column(name = "city") // Mapping to the column "city" in the database
	private String city;

	@JsonManagedReference("team-player")
	@OneToMany(mappedBy = "team")
	private Set<Player> players;

	@JsonManagedReference("team-coach")
	@OneToOne(mappedBy = "team")
	private Coach coach;
	private Long idCoach;

	public Long getIdCoach() {
		return idCoach;
	}

	public void setIdCoach(Long idCoach) {
		this.idCoach = idCoach;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "team")
	private List<Schema> schemas;

	@OneToMany(mappedBy = "team")
	private List<Announcement> announcements;

	// Getters and setters
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public List<Schema> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
}
}