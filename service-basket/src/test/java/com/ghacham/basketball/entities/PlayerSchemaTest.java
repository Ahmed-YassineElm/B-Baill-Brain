package com.ghacham.basketball.entities;

import com.ghacham.basketball.entities.PlayerSchema;
import com.ghacham.basketball.entities.Schema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerSchemaTest {

    @Test
    public void testPlayerSchemaCreation() {
        // Création d'un schéma fictif pour le test
        Schema schema = new Schema();
        schema.setSchemaId(1L);
        schema.setTitle("Schema A");
        schema.setDescription("Schema A description");

        // Création d'un objet PlayerSchema
        PlayerSchema playerSchema = new PlayerSchema();
        playerSchema.setId(1L);
        playerSchema.setSchema(schema);
        playerSchema.setPlayerId(2L);
        playerSchema.setPositionX(10);
        playerSchema.setPositionY(20);

        // Vérification des attributs de PlayerSchema
        assertEquals(1L, playerSchema.getId());
        assertEquals(schema, playerSchema.getSchema());
        assertEquals(2L, playerSchema.getPlayerId());
        assertEquals(10, playerSchema.getPositionX());
        assertEquals(20, playerSchema.getPositionY());
    }
}
