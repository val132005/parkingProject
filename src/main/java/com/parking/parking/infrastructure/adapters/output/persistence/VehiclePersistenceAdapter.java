package com.parking.parking.infrastructure.adapters.output.persistence;

import com.parking.parking.application.port.output.VehiclePersistencePort;
import com.parking.parking.domain.model.Vehicle;
import com.parking.parking.infrastructure.adapters.output.persistence.mapper.VehiclePersistenceMapper;
import com.parking.parking.infrastructure.adapters.output.persistence.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehiclePersistenceAdapter implements VehiclePersistencePort {

    private final VehicleRepository repository;
    private final VehiclePersistenceMapper mapper;


    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        return repository.findByPlate(plate)
                .map(mapper::toVehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return mapper.toVehicleList(repository.findAll());
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return mapper.toVehicle(repository.save(mapper.toVehicleEntity(vehicle)));
    }

    @Override
    public void deleteByPlate(String plate) {
        repository.deleteByPlate(plate);

    }
}
