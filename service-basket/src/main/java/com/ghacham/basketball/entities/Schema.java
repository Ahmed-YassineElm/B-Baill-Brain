package com.ghacham.basketball.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Schema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schemaId;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "team_id") // Assuming the column name in Schema table referencing Team is team_id
	private Team team;

	@ElementCollection
	@CollectionTable(name = "schema_player", joinColumns = @JoinColumn(name = "schema_id"))
	@Column(name = "player_id")
	private Set<Long> playerIds;

	@Enumerated(EnumType.STRING)
	private Visibility visibility;

	// Getters and setters

	public Long getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(Long schemaId) {
		this.schemaId = schemaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<Long> getPlayerIds() {
		return playerIds;
	}

	public void setPlayerIds(Set<Long> playerIds) {
		this.playerIds = playerIds;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}
