package com.parking.parking.infrastructure.adapters.output.persistence.entity;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.util.Date;

public class VehicleEntity {


    @Getter
    @Setter
    @Entity(name = "vehicles")
    @NoArgsConstructor
    @AllArgsConstructor
    public class Vehicle {

        @Id
        private String plate;
        private String color;
        private String make;
        private  String owner;
        private int model;
        private Date dayOfEntry;
        private Date dayOfDeparture;
        private Time timeOfEntry;
        private Time timeOfDeparture;


    }
}
