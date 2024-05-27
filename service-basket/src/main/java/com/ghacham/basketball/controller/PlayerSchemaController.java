package com.ghacham.basketball.controller;

import com.ghacham.basketball.entities.PlayerSchema;
import com.ghacham.basketball.services.PlayerSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player-schemas")
public class PlayerSchemaController {

    private final PlayerSchemaService playerSchemaService;

    @Autowired
    public PlayerSchemaController(PlayerSchemaService playerSchemaService) {
        this.playerSchemaService = playerSchemaService;
    }

    @GetMapping
    public List<PlayerSchema> getAllPlayerSchemas() {
        return playerSchemaService.getAllPlayerSchemas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerSchema> getPlayerSchemaById(@PathVariable Long id) {
        Optional<PlayerSchema> playerSchema = playerSchemaService.getPlayerSchemaById(id);
        return playerSchema.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlayerSchema> createPlayerSchema(@RequestBody PlayerSchema playerSchema) {
        PlayerSchema createdPlayerSchema = playerSchemaService.createPlayerSchema(playerSchema);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayerSchema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerSchema> updatePlayerSchema(@PathVariable Long id, @RequestBody PlayerSchema updatedPlayerSchema) {
        PlayerSchema updatedSchema = playerSchemaService.updatePlayerSchema(id, updatedPlayerSchema);
        return ResponseEntity.ok(updatedSchema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerSchema(@PathVariable Long id) {
        playerSchemaService.deletePlayerSchema(id);
        return ResponseEntity.noContent().build();
    }
}
