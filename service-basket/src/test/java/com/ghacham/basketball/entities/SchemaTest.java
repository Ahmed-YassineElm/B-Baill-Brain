package com.ghacham.basketball.entities;

import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.entities.Visibility;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SchemaTest {

    @Test
    public void testSchemaCreation() {
        // Création d'une équipe fictive pour le test
        Team team = new Team();
        team.setTeamId(1L);
        team.setTeamName("Team A");
        team.setCity("City A");

        // Création d'un ensemble de joueurs fictifs pour le test
        Set<Long> playerIds = new HashSet<>();
        playerIds.add(1L);
        playerIds.add(2L);
        playerIds.add(3L);

        // Création d'un schéma
        Schema schema = new Schema();
        schema.setSchemaId(1L);
        schema.setTitle("Schema 1");
        schema.setDescription("Description of Schema 1");
        schema.setTeam(team);
        schema.setPlayerIds(playerIds);
        schema.setVisibility(Visibility.PUBLIC);

        // Vérification des attributs du schéma
        assertEquals(1L, schema.getSchemaId());
        assertEquals("Schema 1", schema.getTitle());
        assertEquals("Description of Schema 1", schema.getDescription());
        assertEquals(team, schema.getTeam());
        assertEquals(playerIds, schema.getPlayerIds());
        assertEquals(Visibility.PUBLIC, schema.getVisibility());
    }

    @Test
    public void testSchemaSettersAndGetters() {
        // Création d'un schéma vide
        Schema schema = new Schema();

        // Attribution des valeurs aux attributs du schéma
        schema.setSchemaId(1L);
        schema.setTitle("Schema 2");
        schema.setDescription("Description of Schema 2");
        Team team = new Team();
        team.setTeamId(2L);
        team.setTeamName("Team B");
        team.setCity("City B");
        schema.setTeam(team);
        Set<Long> playerIds = new HashSet<>();
        playerIds.add(4L);
        playerIds.add(5L);
        schema.setPlayerIds(playerIds);
        schema.setVisibility(Visibility.PRIVATE);

        // Vérification des getters pour les attributs du schéma
        assertEquals(1L, schema.getSchemaId());
        assertEquals("Schema 2", schema.getTitle());
        assertEquals("Description of Schema 2", schema.getDescription());
        assertEquals(team, schema.getTeam());
        assertEquals(playerIds, schema.getPlayerIds());
        assertEquals(Visibility.PRIVATE, schema.getVisibility());
    }
}
