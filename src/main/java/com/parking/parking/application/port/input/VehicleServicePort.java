package com.parking.parking.application.port.input;

import com.parking.parking.domain.model.Vehicle;

import java.util.List;

    public interface VehicleServicePort{
    Vehicle findByPlate(String plate);
    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    Vehicle update(String plate, Vehicle vehicle);
    void deleteByPlate(String plate);


}
