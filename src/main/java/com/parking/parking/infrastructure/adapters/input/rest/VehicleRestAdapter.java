package com.parking.parking.infrastructure.adapters.input.rest;

import com.parking.parking.application.port.input.VehicleServicePort;
import com.parking.parking.infrastructure.adapters.input.rest.mapper.VehicleRestMapper;
import com.parking.parking.infrastructure.adapters.input.rest.model.request.VehicleCreateRequest;
import com.parking.parking.infrastructure.adapters.input.rest.model.response.VehicleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class VehicleRestAdapter {
    private final VehicleServicePort vehicleServicePort;
    private final VehicleRestMapper vehicleRestMapper;

    @GetMapping("/ListadoDeVehiculos")
    public List<VehicleResponse> findAll(){
        return vehicleRestMapper.toVehicleResponseList(vehicleServicePort.findAll());
    }

    @GetMapping("/ConsultaEspecifica")
    public VehicleResponse findByPlate(@PathVariable String plate){
        return vehicleRestMapper.toVehicleResponse(vehicleServicePort.findByPlate(plate));
    }

    @PostMapping("/Registro")
    public ResponseEntity<VehicleResponse> save(@Valid @RequestBody VehicleCreateRequest vehicleCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleRestMapper.toVehicleResponse(
                        vehicleServicePort.save(vehicleRestMapper.toVehicle(vehicleCreateRequest))));
    }

    @PutMapping("/ConsultaEspecifica/actualizacion")
    public  VehicleResponse update(@PathVariable String plate, @Valid @RequestBody VehicleCreateRequest vehicleCreateRequest){
        return vehicleRestMapper.toVehicleResponse(
                vehicleServicePort.update(plate, vehicleRestMapper.toVehicle(vehicleCreateRequest))
        );
    }

    @DeleteMapping("/ConsultaEspecifica/eliminacion")
    public void delete(@PathVariable String plate){
        vehicleServicePort.deleteByPlate(plate);
    }

}
