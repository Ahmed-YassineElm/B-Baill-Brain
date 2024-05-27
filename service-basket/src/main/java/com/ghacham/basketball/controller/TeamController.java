package com.ghacham.basketball.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.clients.UtilisateurClient;
import com.ghacham.basketball.entities.Team;
import com.ghacham.basketball.services.TeamService;

import java.util.List;


@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;
    
    @Autowired
    private UtilisateurClient utilisateurClient;

    // Endpoint pour récupérer tous les teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Endpoint pour récupérer un team par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Team team = teamService.getTeamById(teamId);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team);
    }

    @GetMapping("/role/{id}")
    public boolean isThisCoach(@PathVariable Long id) {
         return  utilisateurClient.getUserRole(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {

        System.out.println("good-----------------");
        if(utilisateurClient.getUserRole(team.getIdCoach())){
            System.out.println("good-----------------");
            return teamService.createTeam(team);
        }else{
            System.out.println("bad-----------------");
            return null;
        }

    }




//    @PostMapping("/create")
//    public Long createTeam(@RequestBody IdRequest idRequest) {
//        Long id = idRequest.getId();
//
//        // Vérifie le rôle de l'utilisateur avec l'ID
//        String role = utilisateurClient.getUserRole(idRequest.getId());
//        System.out.println("---------"+id);
//        System.out.println("---------"+role);
//        if (!"COACH".equals(role)) {
//            System.out.println("--------*********************-");
//            throw new UnauthorizedException("Seuls les coachs peuvent créer des équipes");
//        }
//
//        // Appeler le service pour créer l'équipe
//        return id;
//    }


    // Endpoint pour mettre à jour un team existant
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long teamId, @RequestBody Team teamDetails) {
        Team updatedTeam = teamService.updateTeam(teamId, teamDetails);
        if (updatedTeam == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedTeam);
    }

    // Endpoint pour supprimer un team
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(value = "id") Long teamId) {
        if (!teamService.existsById(teamId)) {
            return ResponseEntity.notFound().build();
        }
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
//    @PostMapping("/{id}/players")
//    public Team addPlayersToTeam(@PathVariable Long id, @RequestBody Set<Long> playerIds, @RequestHeader("Authorization") Long idCoach) {
//        String role = utilisateurClient.getUserRole(idCoach);
//        if (!"COACH".equals(role)) {
//            throw new UnauthorizedException("Only coaches can add players to teams");
//        }
//        Team team = teamService.getTeamById(id);
//        for (Long playerId : playerIds) {
//            Player player = utilisateurClient.getPlayerById(playerId);
//            team.getPlayers().add(player);
//        }
//        return teamService.updateTeam(id, team);
//    }
}
//@Data
//class IdRequest {
//    private Long id;
//}