package com.ghacham.basketball.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "player_schema")
public class PlayerSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schema_id")
    private Schema schema;

    private Long playerId;

    @Column(name = "position_x")
    private int positionX;

    @Column(name = "position_y")
    private int positionY;

    // Constructors, Getters, and Setters

    public PlayerSchema() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }


    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public Long getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        return "PlayerSchema{" +
                "id=" + id +
                ", schema=" + schema +
                ", playerId=" + playerId +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public PlayerSchema(Long id, Schema schema, Long playerId, int positionX, int positionY) {
        this.id = id;
        this.schema = schema;
        this.playerId = playerId;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


}
