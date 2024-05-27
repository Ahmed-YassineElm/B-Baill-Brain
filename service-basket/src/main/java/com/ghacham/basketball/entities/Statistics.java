package com.ghacham.basketball.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "statistics")

public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statsId;

    private int points;
    private int rebounds;
    public Long getStatsId() {
		return statsId;
	}
	public void setStatsId(Long statsId) {
		this.statsId = statsId;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getRebounds() {
		return rebounds;
	}
	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	private int assists;

    // Getters and setters
}
