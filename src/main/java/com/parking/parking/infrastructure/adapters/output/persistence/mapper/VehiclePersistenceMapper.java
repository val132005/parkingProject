package com.parking.parking.infrastructure.adapters.output.persistence.mapper;

import com.parking.parking.domain.model.Vehicle;
import com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiclePersistenceMapper {

    VehicleEntity toVehicleEntity(Vehicle vehicle);
    Vehicle toVehicle(VehicleEntity vehicleEntity);
    List<Vehicle> toVehicleList(List<VehicleEntity> entityList);




}
