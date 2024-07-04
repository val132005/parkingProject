package com.parking.parking.application.service;

import com.parking.parking.application.port.input.VehicleServicePort;
import com.parking.parking.domain.exception.VehicleNotFoundException;
import com.parking.parking.domain.model.Vehicle;
import com.parking.parking.infrastructure.adapters.input.rest.VehicleRestAdapter;
import com.parking.parking.infrastructure.adapters.input.rest.mapper.VehicleRestMapper;
import com.parking.parking.infrastructure.adapters.input.rest.model.request.VehicleCreateRequest;
import com.parking.parking.infrastructure.adapters.input.rest.model.response.VehicleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VehicleRestAdapterTest {

    @Mock
    private VehicleServicePort vehicleServicePort;

    @Mock
    private VehicleRestMapper vehicleRestMapper;

    @InjectMocks
    private VehicleRestAdapter vehicleRestAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnListOfVehicleResponses() {
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle());
        vehicles.add(new Vehicle());
        List<VehicleResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(new VehicleResponse());
        expectedResponses.add(new VehicleResponse());
        when(vehicleServicePort.findAll()).thenReturn(vehicles);
        when(vehicleRestMapper.toVehicleResponseList(vehicles)).thenReturn(expectedResponses);

        // Act
        List<VehicleResponse> actualResponses = vehicleRestAdapter.findAll();

        // Assert
        assertNotNull(actualResponses);
        assertEquals(expectedResponses.size(), actualResponses.size());
    }

    @Test
    void findByPlate_existingPlate_shouldReturnVehicleResponse() {
        // Arrange
        String plate = "ABC-123";
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(plate);
        VehicleResponse expectedResponse = new VehicleResponse();
        expectedResponse.setPlate(plate);
        when(vehicleServicePort.findByPlate(plate)).thenReturn(vehicle);
        when(vehicleRestMapper.toVehicleResponse(vehicle)).thenReturn(expectedResponse);

        // Act
        VehicleResponse actualResponse = vehicleRestAdapter.findByPlate(plate);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getPlate(), actualResponse.getPlate());
    }

    @Test
    void findByPlate_nonExistingPlate_shouldThrowException() {
        // Arrange
        String plate = "XYZ-456";
        when(vehicleServicePort.findByPlate(plate)).thenThrow(new VehicleNotFoundException());

        // Act and Assert
        assertThrows(VehicleNotFoundException.class, () -> {
            vehicleRestAdapter.findByPlate(plate);
        });
    }

    @Test
    void save_validRequest_shouldReturnCreatedStatusAndVehicleResponse() {
        // Arrange
        VehicleCreateRequest request = new VehicleCreateRequest();
        Vehicle vehicle = new Vehicle();
        VehicleResponse expectedResponse = new VehicleResponse();
        when(vehicleRestMapper.toVehicle(request)).thenReturn(vehicle);
        when(vehicleServicePort.save(vehicle)).thenReturn(vehicle);
        when(vehicleRestMapper.toVehicleResponse(vehicle)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<VehicleResponse> responseEntity = vehicleRestAdapter.save(request);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void save_invalidRequest_shouldThrowException() {
        // Arrange
        VehicleCreateRequest request = new VehicleCreateRequest();
        when(vehicleRestMapper.toVehicle(request)).thenThrow(new ConstraintViolationException("Validation failed", null));

        // Act and Assert
        assertThrows(ValidationException.class, () -> {
            vehicleRestAdapter.save(request);
        });
    }

    @Test
    void update_existingPlateAndValidRequest_shouldReturnVehicleResponse() {
        // Arrange
        String plate = "ABC-123";
        VehicleCreateRequest request = new VehicleCreateRequest();
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(plate);
        VehicleResponse expectedResponse = new VehicleResponse();
        expectedResponse.setPlate(plate);
        when(vehicleRestMapper.toVehicle(request)).thenReturn(vehicle);
        when(vehicleServicePort.update(plate, vehicle)).thenReturn(vehicle);
        when(vehicleRestMapper.toVehicleResponse(vehicle)).thenReturn(expectedResponse);

        // Act
        VehicleResponse actualResponse = vehicleRestAdapter.update(plate, request);

        // Assert
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getPlate(), actualResponse.getPlate());
    }



    @Test
    void delete_existingPlate_shouldReturnNoContent() {
        // Arrange
        String plate = "ABC-123";

        // Act
        vehicleRestAdapter.delete(plate);

        // Assert: Verify that vehicleServicePort.deleteByPlate was called once
        verify(vehicleServicePort, times(1)).deleteByPlate(plate);
    }

    @Test
    void delete_nonExistingPlate_shouldThrowException() {
        // Arrange
        String plate = "XYZ-456";
        doThrow(new VehicleNotFoundException()).when(vehicleServicePort).deleteByPlate(plate);

        // Act and Assert
        assertThrows(VehicleNotFoundException.class, () -> {
            vehicleRestAdapter.delete(plate);
        });
    }
}