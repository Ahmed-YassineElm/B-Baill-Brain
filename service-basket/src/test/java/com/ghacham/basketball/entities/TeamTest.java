package com.ghacham.basketball.entities;

import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.entities.Coach;
import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.entities.Announcement;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeamTest {

    @Test
    public void testTeamCreation() {
        // Création d'une équipe fictive pour le test
        Team team = new Team();
        team.setTeamId(1L);
        team.setTeamName("Team A");
        team.setCity("City A");

        // Création de joueurs fictifs pour l'équipe
        Player player1 = new Player();
        player1.setPlayerId(1L);
        player1.setPlayerName("Player 1");

        Player player2 = new Player();
        player2.setPlayerId(2L);
        player2.setPlayerName("Player 2");

        Set<Player> players = new HashSet<>();
        players.add(player1);
        players.add(player2);

        team.setPlayers(players);

        // Création d'un coach fictif pour l'équipe
        Coach coach = new Coach();
        coach.setCoachId(1L);
        coach.setCoachName("Coach 1");

        team.setCoach(coach);

        // Création de schémas et d'annonces fictifs pour l'équipe
        Schema schema1 = new Schema();
        schema1.setSchemaId(1L);
        schema1.setTitle("Schema 1");

        Schema schema2 = new Schema();
        schema2.setSchemaId(2L);
        schema2.setTitle("Schema 2");

        Announcement announcement1 = new Announcement();
        announcement1.setAnnouncementId(1L);
        announcement1.setContent("Announcement 1");

        Announcement announcement2 = new Announcement();
        announcement2.setAnnouncementId(2L);
        announcement2.setContent("Announcement 2");

        List<Schema> schemas = List.of(schema1, schema2);
        List<Announcement> announcements = List.of(announcement1, announcement2);

        team.setSchemas(schemas);
        team.setAnnouncements(announcements);

        // Vérification des attributs de l'équipe
        assertEquals(1L, team.getTeamId());
        assertEquals("Team A", team.getTeamName());
        assertEquals("City A", team.getCity());
        assertEquals(players, team.getPlayers());
        assertEquals(coach, team.getCoach());
        assertEquals(schemas, team.getSchemas());
        assertEquals(announcements, team.getAnnouncements());
    }
}
