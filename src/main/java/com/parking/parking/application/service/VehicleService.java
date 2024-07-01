package com.parking.parking.application.service;

import com.parking.parking.application.port.output.VehiclePersistencePort;
import com.parking.parking.application.port.input.VehicleServicePort;
import com.parking.parking.domain.exception.VehicleNotFoundException;
import com.parking.parking.domain.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements VehicleServicePort {

    private final VehiclePersistencePort persistencePort;

    @Override
    public Vehicle findByPlate(String plate) {
        return persistencePort.findByPlate(plate)
                .orElseThrow(VehicleNotFoundException::new);

    }

    @Override
    public List<Vehicle> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return persistencePort.save(vehicle);
    }

    @Override
    public Vehicle update(String plate, Vehicle vehicle) {
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
                .orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public void deleteByPlate(String plate) {
        if (persistencePort.findByPlate(plate).isEmpty()){
            throw new VehicleNotFoundException();
        }
        persistencePort.deleteByPlate(plate);

    }
}
