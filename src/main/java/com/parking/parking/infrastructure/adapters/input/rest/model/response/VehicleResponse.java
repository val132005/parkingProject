package com.parking.parking.infrastructure.adapters.input.rest.model.response;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {

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
