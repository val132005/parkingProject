package com.parking.parking.infrastructure.adapters.output.persistence.repository;

import com.parking.parking.infrastructure.adapters.output.persistence.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    Optional<VehicleEntity> findByPlate(String plate);

    void deleteByPlate(String plate);




}
