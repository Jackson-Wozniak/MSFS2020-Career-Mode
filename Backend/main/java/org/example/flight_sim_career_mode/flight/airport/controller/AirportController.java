package org.example.flight_sim_career_mode.flight.airport.controller;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/airports")
@AllArgsConstructor
public class AirportController {

    @Autowired
    private final AirportService airportService;

    //Filter all airports in DB to find countries that contain at least 100 airports
    //These are the only countries that pilots can use for country of origin
    @RequestMapping(value = "/countries")
    public List<String> getCountriesForPilots(){
        return null;
    }
}
