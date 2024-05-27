package com.ghacham.basketball.services;
import com.ghacham.basketball.entities.PlayerSchema;
import com.ghacham.basketball.repository.PlayerSchemaRepository;
import com.ghacham.basketball.services.PlayerSchemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerSchemaServiceTest {

    @Mock
    private PlayerSchemaRepository playerSchemaRepository;

    @InjectMocks
    private PlayerSchemaService playerSchemaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePlayerSchema() {
        // Mock data
        PlayerSchema playerSchema = new PlayerSchema();
        when(playerSchemaRepository.save(playerSchema)).thenReturn(playerSchema);

        // Call the method
        PlayerSchema result = playerSchemaService.createPlayerSchema(playerSchema);

        // Verify the result
        assertEquals(playerSchema, result);
    }

    @Test
    public void testGetAllPlayerSchemas() {
        // Mock data
        List<PlayerSchema> playerSchemas = Arrays.asList(new PlayerSchema(), new PlayerSchema());
        when(playerSchemaRepository.findAll()).thenReturn(playerSchemas);

        // Call the method
        List<PlayerSchema> result = playerSchemaService.getAllPlayerSchemas();

        // Verify the result
        assertEquals(playerSchemas.size(), result.size());
    }

    // Add tests for other methods such as getPlayerSchemaById, updatePlayerSchema, deletePlayerSchema, etc.
}
