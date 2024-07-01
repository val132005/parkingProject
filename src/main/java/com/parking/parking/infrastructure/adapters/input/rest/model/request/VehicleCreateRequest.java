package com.parking.parking.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCreateRequest {

    @Pattern(regexp = "^[A-Z]{3}-\\d{3}$", message = "La placa debe tener el formato AAA-123")
    @NotBlank(message = "La placa es requerida")
    private String plate;

    @Size(min = 4, max = 20, message = "El color debe tener entre 4 y 20 caracteres")
    @Pattern(regexp = "^[^0-9]+$", message = "El color no debe contener números")
    @NotBlank(message = "El color es requerido")
    private String color;

    @Size(min = 4, max = 30, message = "La marca debe tener entre 4 y 30 caracteres")
    @NotBlank(message = "La marca es requerida")
    private String make;

    @Size(min = 3, max = 50, message = "El dueño debe tener entre 3 y 50 caracteres")
    @NotBlank(message = "El dueño es requerido")
    private  String owner;

    @Positive(message = "El modelo debe ser un número entero positivo")
    @Digits(integer = 4, fraction = 0, message = "El modelo debe tener 4 dígitos")
    @NotNull(message = "El modelo es requerido")
    private int model;

    @Pattern(regexp = "^\\s*(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\s*$", message = "La fecha de salida debe tener el formato DD/MM/AAAA")
    private Date dayOfEntry;

    @Pattern(regexp = "^\\s*(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\s*$", message = "La fecha de salida debe tener el formato DD/MM/AAAA")
    private Date dayOfDeparture;

    @Pattern(regexp = "^(1[0-2]|0[1-9]):[0-5][0-9] (AM|PM)$", message = "La hora de entrada debe tener el formato HH:MM AM/PM")
    private Time timeOfEntry;

    @Pattern(regexp = "^(1[0-2]|0[1-9]):[0-5][0-9] (AM|PM)$", message = "La hora de salida debe tener el formato HH:MM AM/PM")
    private Time timeOfDeparture;

}
