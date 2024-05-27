package com.ghacham.basketball.controller;

import com.ghacham.basketball.entities.PlayerSchema;
import com.ghacham.basketball.services.PlayerSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ghacham.basketball.entities.Player;
import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.services.SchemaService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/schemas")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;

    @Autowired
    private PlayerSchemaService playerSchemaService;

    @GetMapping
    public List<Schema> getAllSchemas() {
        return schemaService.getAllSchemas();
    }

    @GetMapping("/{id}")
    public Schema getSchemaById(@PathVariable Long id) {
        return schemaService.getSchemaById(id);
    }

    @PostMapping
    public Schema createSchema(@RequestBody Schema schema) {
        return schemaService.createSchema(schema);
    }
    @PostMapping("/{ids}/{playerId}/player")
    public void addPlayerToSchema(@PathVariable Long ids, @PathVariable Long playerId) {

        PlayerSchema Player=new PlayerSchema(55L,schemaService.getSchemaById(ids),playerId,12,15);
        PlayerSchema createdPlayerSchema = playerSchemaService.createPlayerSchema(Player);
        System.out.println("********************************"+createdPlayerSchema.toString());
    }

    @PutMapping("/{id}")
    public Schema updateSchema(@PathVariable Long id, @RequestBody Schema updatedSchema) {
        return schemaService.updateSchema(id, updatedSchema);
    }

    @DeleteMapping("/{id}")
    public void deleteSchema(@PathVariable Long id) {
        schemaService.deleteSchema(id);
    }

    /*@PostMapping("/{id}/players")
    public void addPlayersToSchema(@PathVariable Long id, @RequestBody Set<Long> playerIds) {
        playerIds.forEach(playerId -> {
            Player player = utilisateurClient.getPlayerById(playerId);
            schemaService.addPlayerToSchema(id, player);
        });
    }

    @DeleteMapping("/{id}/players")
    public void removePlayersFromSchema(@PathVariable Long id, @RequestBody Set<Long> playerIds) {
        playerIds.forEach(playerId -> {
            Player player = utilisateurClient.getPlayerById(playerId);
            schemaService.removePlayerFromSchema(id, player);
        });
    }*/

    // Autres méthodes pour la gestion des schémas
}
