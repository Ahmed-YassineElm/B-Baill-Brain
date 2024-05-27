package com.ghacham.basketball.services;

import com.ghacham.basketball.entities.PlayerSchema;
import com.ghacham.basketball.repository.PlayerSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerSchemaService {

    private final PlayerSchemaRepository playerSchemaRepository;

    @Autowired
    public PlayerSchemaService(PlayerSchemaRepository playerSchemaRepository) {
        this.playerSchemaRepository = playerSchemaRepository;
    }

    public PlayerSchema createPlayerSchema(PlayerSchema playerSchema) {
        return playerSchemaRepository.save(playerSchema);
    }

    public List<PlayerSchema> getAllPlayerSchemas() {
        return playerSchemaRepository.findAll();
    }

    public Optional<PlayerSchema> getPlayerSchemaById(Long id) {
        return playerSchemaRepository.findById(id);
    }

    public PlayerSchema updatePlayerSchema(Long id, PlayerSchema updatedPlayerSchema) {
        updatedPlayerSchema.setId(id);
        return playerSchemaRepository.save(updatedPlayerSchema);
    }

    public void deletePlayerSchema(Long id) {
        playerSchemaRepository.deleteById(id);
    }
}
