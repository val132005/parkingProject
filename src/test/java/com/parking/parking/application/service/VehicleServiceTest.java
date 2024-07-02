package com.parking.parking.application.service;

import com.parking.parking.application.port.output.VehiclePersistencePort;
import com.parking.parking.domain.exception.VehicleNotFoundException;
import com.parking.parking.domain.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {
    @Mock
    private VehiclePersistencePort persistencePort;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindByPlate_WhenPlateExists_ExpectVehicleReturned() {
        // Mocking behavior
        String plate = "ABC-123";
        Vehicle expectedVehicle = new Vehicle();
        expectedVehicle.setPlate(plate);
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.of(expectedVehicle));

        // Calling the service method
        Vehicle result = vehicleService.findByPlate(plate);

        // Assertions
        assertEquals(plate, result.getPlate());
    }

    @Test
    void testFindByPlate_WhenPlateNotExists_ExpectVehicleNotFoundException() {
        // Mocking behavior
        String plate = "XYZ-456";
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.empty());

        // Calling the service method and asserting exception
        assertThrows(VehicleNotFoundException.class, () -> vehicleService.findByPlate(plate));
    }

    @Test
    void testFindAll_ExpectListOfVehiclesReturned() {
        // Mocking behavior
        List<Vehicle> vehicles = Arrays.asList(new Vehicle(), new Vehicle());
        when(persistencePort.findAll()).thenReturn(vehicles);

        // Calling the service method
        List<Vehicle> result = vehicleService.findAll();

        // Assertions
        assertEquals(2, result.size());
    }

    @Test
    void testSaveVehicle_ExpectSavedVehicle() {
        // Mocking behavior
        Vehicle vehicle = new Vehicle();
        when(persistencePort.save(vehicle)).thenReturn(vehicle);

        // Calling the service method
        Vehicle savedVehicle = vehicleService.save(vehicle);

        // Assertions
        assertEquals(vehicle, savedVehicle);
    }

    @Test
    void testUpdateVehicle_ExpectUpdatedVehicle() {
        // Mocking behavior
        String plate = "ABC123";
        Vehicle updatedVehicle = new Vehicle();
        updatedVehicle.setPlate(plate);
        updatedVehicle.setColor("Red");
        updatedVehicle.setMake("Toyota");
        updatedVehicle.setModel(2024);

        when(persistencePort.findByPlate(plate)).thenReturn(Optional.of(new Vehicle()));
        when(persistencePort.save(any(Vehicle.class))).thenReturn(updatedVehicle);

        // Calling the service method
        Vehicle vehicleToUpdate = new Vehicle();
        vehicleToUpdate.setPlate(plate);

        Vehicle returnedVehicle = vehicleService.update(plate, vehicleToUpdate);

        // Assertions
        assertEquals(updatedVehicle, returnedVehicle);
        verify(persistencePort, times(1)).findByPlate(plate);
        verify(persistencePort, times(1)).save(any(Vehicle.class));
    }

    @Test
    void testDeleteByPlate_ExpectVoid() {
        // Mocking behavior
        String plate = "ABC-123";

        // Mockear findByPlate para devolver Optional.empty() cuando se llame con plate
        when(persistencePort.findByPlate(plate)).thenReturn(Optional.empty());

        // Calling the service method and expecting VehicleNotFoundException
        assertThrows(VehicleNotFoundException.class, () -> vehicleService.deleteByPlate(plate));

        // Verification
        verify(persistencePort, times(1)).findByPlate(plate);
        verify(persistencePort, never()).deleteByPlate(plate); // Verifica que deleteByPlate no se llamó
    }
}
