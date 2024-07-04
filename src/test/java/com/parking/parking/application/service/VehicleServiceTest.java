package com.parking.parking.application.service;


import com.parking.parking.application.port.output.VehiclePersistencePort;
import com.parking.parking.domain.exception.VehicleNotFoundException;
import com.parking.parking.domain.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {

    @Mock
    private VehiclePersistencePort persistencePort;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByPlate_existingPlate_shouldReturnVehicle() {
        // Arrange
        String plate = "ABC-123";
        Vehicle expectedVehicle = new Vehicle();
        expectedVehicle.setPlate(plate);
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.of(expectedVehicle));

        // Act
        Vehicle foundVehicle = vehicleService.findByPlate(plate);

        // Assert
        assertNotNull(foundVehicle);
        assertEquals(plate, foundVehicle.getPlate());
    }

    @Test
    void findByPlate_nonExistingPlate_shouldThrowException() {
        // Arrange
        String plate = "XYZ-456";
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(VehicleNotFoundException.class, () -> {
            vehicleService.findByPlate(plate);
        });
    }

    @Test
    void findAll_shouldReturnListOfVehicles() {
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());
        when(persistencePort.findAll()).thenReturn(vehicles);

        // Act
        List<Vehicle> foundVehicles = vehicleService.findAll();

        // Assert
        assertEquals(2, foundVehicles.size());
    }

    @Test
    void save_shouldReturnSavedVehicle() {
        // Arrange
        Vehicle vehicleToSave = new Vehicle();
        when(persistencePort.save(any(Vehicle.class))).thenReturn(vehicleToSave);

        // Act
        Vehicle savedVehicle = vehicleService.save(vehicleToSave);

        // Assert
        assertNotNull(savedVehicle);
    }

    @Test
    void update_existingVehicle_shouldReturnUpdatedVehicle() {
        // Arrange
        String plate = "ABC-123";
        Vehicle existingVehicle = new Vehicle();
        existingVehicle.setPlate(plate);
        Vehicle updatedVehicle = new Vehicle();
        updatedVehicle.setPlate(plate);
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.of(existingVehicle));
        when(persistencePort.save(any(Vehicle.class))).thenReturn(updatedVehicle);

        // Act
        Vehicle returnedVehicle = vehicleService.update(plate, updatedVehicle);

        // Assert
        assertNotNull(returnedVehicle);
        assertEquals(updatedVehicle.getPlate(), returnedVehicle.getPlate());
    }

    @Test
    void update_nonExistingVehicle_shouldThrowException() {
        // Arrange
        String plate = "XYZ-456";
        Vehicle updatedVehicle = new Vehicle();
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(VehicleNotFoundException.class, () -> {
            vehicleService.update(plate, updatedVehicle);
        });
    }

    @Test
    void deleteByPlate_existingPlate_shouldDeleteVehicle() {
        // Arrange
        String plate = "ABC-123";
        Vehicle existingVehicle = new Vehicle();
        existingVehicle.setPlate(plate);
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.of(existingVehicle));

        // Act
        vehicleService.deleteByPlate(plate);

        // Assert: Verify that deleteByPlate was called once
        verify(persistencePort, times(1)).deleteByPlate(plate);
    }

    @Test
    void deleteByPlate_nonExistingPlate_shouldThrowException() {
        // Arrange
        String plate = "XYZ-456";
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(VehicleNotFoundException.class, () -> {
            vehicleService.deleteByPlate(plate);
        });
    }
}
