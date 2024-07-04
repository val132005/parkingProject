package com.parking.parking.application.service;

import com.parking.parking.application.port.input.VehicleServicePort;
import com.parking.parking.application.port.output.VehiclePersistencePort;
import com.parking.parking.domain.exception.VehicleNotFoundException;
import com.parking.parking.domain.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements VehicleServicePort {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);

    private final VehiclePersistencePort persistencePort;

    @Override
    public Vehicle findByPlate(String plate) {
        logger.debug("Finding vehicle by plate: {}", plate);
        long startTime = System.currentTimeMillis();
        Vehicle vehicle = persistencePort.findByPlate(plate)
                .orElseThrow(() -> {
                    logger.warn("Vehicle not found for plate: {}", plate);
                    return new VehicleNotFoundException();
                });
        long endTime = System.currentTimeMillis();
        logger.info("Found vehicle {} in {} ms", vehicle, (endTime - startTime));
        return vehicle;

    }

    @Override
    public List<Vehicle> findAll() {
        logger.debug("Finding all vehicles");
        long startTime = System.currentTimeMillis();
        List<Vehicle> vehicles = persistencePort.findAll();
        long endTime = System.currentTimeMillis();
        logger.info("Found {} vehicles in {} ms", vehicles.size(), (endTime - startTime));
        return vehicles;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        logger.debug("Saving vehicle: {}", vehicle);
        long startTime = System.currentTimeMillis();
        Vehicle savedVehicle = persistencePort.save(vehicle);
        long endTime = System.currentTimeMillis();
        logger.info("Saved vehicle {} in {} ms", savedVehicle, (endTime - startTime));
        return savedVehicle;
    }

    @Override
    public Vehicle update(String plate, Vehicle vehicle) {
        logger.debug("Updating vehicle with plate: {}, new details: {}", plate, vehicle);

        long startTime = System.currentTimeMillis();
        Vehicle existingVehicle = persistencePort.findByPlate(plate)
                .orElseThrow(() -> {
                    logger.warn("Vehicle not found for update with plate: {}", plate);
                    return new VehicleNotFoundException();
                });

        existingVehicle.setPlate(vehicle.getPlate());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setMake(vehicle.getMake());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setDayOfEntry(vehicle.getDayOfEntry());
        existingVehicle.setDayOfDeparture(vehicle.getDayOfDeparture());
        existingVehicle.setTimeOfEntry(vehicle.getTimeOfEntry());
        existingVehicle.setTimeOfDeparture(vehicle.getTimeOfDeparture());

        Vehicle updatedVehicle = persistencePort.save(existingVehicle);

        long endTime = System.currentTimeMillis();
        logger.info("Updated vehicle {} in {} ms", updatedVehicle, (endTime - startTime));
        return updatedVehicle;
    }

    @Override
    public void deleteByPlate(String plate) {
        logger.debug("Deleting vehicle by plate: {}", plate);
        long startTime = System.currentTimeMillis();
        if (persistencePort.findByPlate(plate).isEmpty()){
            logger.warn("Vehicle not found for deletion with plate: {}", plate);
            throw new VehicleNotFoundException();
        }
        persistencePort.deleteByPlate(plate);
        long endTime = System.currentTimeMillis();
        logger.info("Deleted vehicle with plate {} in {} ms", plate, (endTime - startTime));

    }
}
