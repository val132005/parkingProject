package com.parking.parking.application.port.output;

import com.parking.parking.domain.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehiclePersistencePort {
    Optional<Vehicle> findByPlate(String plate);
    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    void  deleteByPlate(String plate);

}
