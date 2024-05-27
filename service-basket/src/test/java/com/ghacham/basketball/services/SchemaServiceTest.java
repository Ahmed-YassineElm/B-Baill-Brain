package com.ghacham.basketball.services;

import com.ghacham.basketball.entities.Schema;
import com.ghacham.basketball.repository.SchemaRepository;
import com.ghacham.basketball.services.SchemaService;
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

public class SchemaServiceTest {

    @Mock
    private SchemaRepository schemaRepository;

    @InjectMocks
    private SchemaService schemaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSchemas() {
        // Mock data
        List<Schema> schemas = Arrays.asList(new Schema(), new Schema());
        when(schemaRepository.findAll()).thenReturn(schemas);

        // Call the method
        List<Schema> result = schemaService.getAllSchemas();

        // Verify the result
        assertEquals(schemas.size(), result.size());
    }

    @Test
    public void testGetSchemaById() {
        // Mock data
        long id = 1L;
        Schema schema = new Schema();
        when(schemaRepository.findById(id)).thenReturn(Optional.of(schema));

        // Call the method
        Schema result = schemaService.getSchemaById(id);

        // Verify the result
        assertEquals(schema, result);
    }

    // Add tests for other methods such as createSchema, updateSchema, deleteSchema, etc.
}
