package com.parking.parking.application.service;

import com.parking.parking.domain.model.Vehicle;
import com.parking.parking.infrastructure.adapters.output.persistence.VehiclePersistenceAdapter;
import com.parking.parking.infrastructure.adapters.output.persistence.mapper.VehiclePersistenceMapper;
import com.parking.parking.infrastructure.adapters.output.persistence.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehiclePersistenceAdapterTest {

    @Mock
    private VehicleRepository repository;

    @Mock
    private VehiclePersistenceMapper mapper;

    @InjectMocks
    private VehiclePersistenceAdapter persistenceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByPlate_existingPlate_shouldReturnVehicle() {
        // Arrange
        String plate = "ABC-123";
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(plate);
        com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity entity = new com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity();
        when(repository.findByPlate(plate)).thenReturn(Optional.of(entity));
        when(mapper.toVehicle(entity)).thenReturn(vehicle);

        // Act
        Optional<Vehicle> result = persistenceAdapter.findByPlate(plate);

        // Assert
        assertEquals(vehicle, result.orElse(null));
    }

    @Test
    void testFindByPlate_nonExistingPlate_shouldReturnEmptyOptional() {
        // Arrange
        String plate = "XYZ-456";
        when(repository.findByPlate(plate)).thenReturn(Optional.empty());

        // Act
        Optional<Vehicle> result = persistenceAdapter.findByPlate(plate);

        // Assert
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testSave_shouldReturnSavedVehicle() {
        // Arrange
        Vehicle vehicle = new Vehicle();
        com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity entity = new com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity();
        when(mapper.toVehicleEntity(vehicle)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toVehicle(entity)).thenReturn(vehicle);

        // Act
        Vehicle savedVehicle = persistenceAdapter.save(vehicle);

        // Assert
        assertEquals(vehicle, savedVehicle);
    }

    @Test
    void testDeleteByPlate_shouldCallRepositoryDelete() {
        // Arrange
        String plate = "ABC-123";

        // Act
        persistenceAdapter.deleteByPlate(plate);

        // Assert
        verify(repository, times(1)).deleteByPlate(plate);
    }

    @Test
    void testFindAll_shouldReturnListOfVehicles() {
        // Arrange
        List<com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity> entities = Collections.singletonList(new com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity());
        List<Vehicle> vehicles = Collections.singletonList(new Vehicle());
        when(repository.findAll()).thenReturn(entities);
        when(mapper.toVehicleList(entities)).thenReturn(vehicles);

        // Act
        List<Vehicle> result = persistenceAdapter.findAll();

        // Assert
        assertEquals(vehicles.size(), result.size());
    }
}
