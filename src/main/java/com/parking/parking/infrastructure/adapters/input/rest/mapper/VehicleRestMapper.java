package com.parking.parking.infrastructure.adapters.input.rest.mapper;

import com.parking.parking.domain.model.Vehicle;
import com.parking.parking.infrastructure.adapters.input.rest.model.request.VehicleCreateRequest;
import com.parking.parking.infrastructure.adapters.input.rest.model.response.VehicleResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleRestMapper {

    Vehicle toVehicle(VehicleCreateRequest request);
    VehicleResponse toVehicleResponse(Vehicle vehicle);

    List<VehicleResponse> toVehicleResponseList(List<Vehicle> vehicleList);


}
