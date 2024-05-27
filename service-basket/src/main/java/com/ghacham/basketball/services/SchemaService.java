package com.ghacham.basketball.services;

import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.repository.SchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemaService {

    @Autowired
    private SchemaRepository schemaRepository;

    public List<Schema> getAllSchemas() {
        System.out.println("Liste des schémas existants : ");
        return schemaRepository.findAll();
    }

    public Schema getSchemaById(Long id) {
        Optional<Schema> schemaOptional = schemaRepository.findById(id);
        return schemaOptional.orElse(null);
    }

    public Schema createSchema(Schema schema) {
        return schemaRepository.save(schema);
    }

    public Schema updateSchema(Long id, Schema updatedSchema) {
        Optional<Schema> schemaOptional = schemaRepository.findById(id);
        if (schemaOptional.isPresent()) {
            Schema existingSchema = schemaOptional.get();
            existingSchema.setTitle(updatedSchema.getTitle());
            existingSchema.setDescription(updatedSchema.getDescription());
            existingSchema.setTeam(updatedSchema.getTeam());
            existingSchema.setPlayerIds(updatedSchema.getPlayerIds());
            existingSchema.setVisibility(updatedSchema.getVisibility());
            return schemaRepository.save(existingSchema);
        }
        return null;
    }

    public void deleteSchema(Long id) {
        schemaRepository.deleteById(id);
    }

    public void addPlayerToSchema(Long schemaId, Long playerId) {
        Optional<Schema> schemaOptional = schemaRepository.findById(schemaId);
        schemaOptional.ifPresent(schema -> {
            schema.getPlayerIds().add(playerId);
            schemaRepository.save(schema);
        });
    }

    public void removePlayerFromSchema(Long schemaId, Long playerId) {
        Optional<Schema> schemaOptional = schemaRepository.findById(schemaId);
        schemaOptional.ifPresent(schema -> {
            schema.getPlayerIds().remove(playerId);
            schemaRepository.save(schema);
        });
    }
}
