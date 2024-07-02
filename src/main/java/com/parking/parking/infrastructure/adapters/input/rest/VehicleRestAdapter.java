package com.parking.parking.infrastructure.adapters.input.rest;

import com.parking.parking.application.port.input.VehicleServicePort;
import com.parking.parking.infrastructure.adapters.input.rest.mapper.VehicleRestMapper;
import com.parking.parking.infrastructure.adapters.input.rest.model.request.VehicleCreateRequest;
import com.parking.parking.infrastructure.adapters.input.rest.model.response.VehicleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class VehicleRestAdapter {

    private static final Logger logger = LoggerFactory.getLogger(VehicleRestAdapter.class);

    private final VehicleServicePort vehicleServicePort;
    private final VehicleRestMapper vehicleRestMapper;

    @GetMapping("/ListadoDeVehiculos")
    public List<VehicleResponse> findAll(){
        logger.info("Fetching all vehicles");
        return vehicleRestMapper.toVehicleResponseList(vehicleServicePort.findAll());
    }

    @GetMapping("/ConsultaEspecifica")
    public VehicleResponse findByPlate(@PathVariable String plate){
        logger.info("Fetching vehicle by plate: {}", plate);
        return vehicleRestMapper.toVehicleResponse(vehicleServicePort.findByPlate(plate));
    }

    @PostMapping("/Registro")
    public ResponseEntity<VehicleResponse> save(@Valid @RequestBody VehicleCreateRequest vehicleCreateRequest){
        logger.info("Saving new vehicle: {}", vehicleCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleRestMapper.toVehicleResponse(
                        vehicleServicePort.save(vehicleRestMapper.toVehicle(vehicleCreateRequest))));
    }

    @PutMapping("/ConsultaEspecifica/actualizacion")
    public  VehicleResponse update(@PathVariable String plate, @Valid @RequestBody VehicleCreateRequest vehicleCreateRequest){
        logger.info("Updating vehicle with plate {}: {}", plate, vehicleCreateRequest);
        return vehicleRestMapper.toVehicleResponse(
                vehicleServicePort.update(plate, vehicleRestMapper.toVehicle(vehicleCreateRequest))
        );
    }

    @DeleteMapping("/ConsultaEspecifica/eliminacion")
    public void delete(@PathVariable String plate){
        logger.info("Deleting vehicle by plate: {}", plate);
        vehicleServicePort.deleteByPlate(plate);
    }

}
