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
        return persistencePort.findByPlate(plate)
                .orElseThrow(() -> {
                    logger.warn("Vehicle not found for plate: {}", plate);
                    return new VehicleNotFoundException();
                });

    }

    @Override
    public List<Vehicle> findAll() {
        logger.debug("Finding all vehicles");
        return persistencePort.findAll();
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
        return persistencePort.findByPlate(plate)
                .map(saveVehicle ->{
                    saveVehicle.setPlate(vehicle.getPlate());
                    saveVehicle.setColor(vehicle.getColor());
                    saveVehicle.setMake(vehicle.getMake());
                    saveVehicle.setModel(vehicle.getModel());
                    saveVehicle.setDayOfEntry(vehicle.getDayOfEntry());
                    saveVehicle.setDayOfDeparture(vehicle.getDayOfDeparture());
                    saveVehicle.setTimeOfEntry(vehicle.getTimeOfEntry());
                    saveVehicle.setTimeOfDeparture(vehicle.getTimeOfDeparture());
                    return persistencePort.save(saveVehicle);
                })
                .orElseThrow(() -> {
                    logger.warn("Vehicle not found for update with plate: {}", plate);
                    return new VehicleNotFoundException();
                });
    }

    @Override
    public void deleteByPlate(String plate) {
        logger.debug("Deleting vehicle by plate: {}", plate);
        if (persistencePort.findByPlate(plate).isEmpty()){
            logger.warn("Vehicle not found for deletion with plate: {}", plate);
            throw new VehicleNotFoundException();
        }
        persistencePort.deleteByPlate(plate);

    }
}
