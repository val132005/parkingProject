package com.parking.parking.domain.model;

import lombok.*;

import java.sql.Time;
import java.util.Date;

//@Entity(name = "vehicles")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    //@Id
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
