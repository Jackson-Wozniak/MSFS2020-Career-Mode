package org.example.flight_sim_career_mode.license.local;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.service.AirportService;
import org.example.flight_sim_career_mode.flight.plane.DefaultPlanes;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.Route;
import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/local")
@AllArgsConstructor
public class LocalFlightController {

    @Autowired
    private final AirportService airportService;
    @Autowired
    private final LocalFlightGenerator localFlightGenerator;

    @RequestMapping()
    public LocalFlight createLocalFlight() throws IOException {
        Pilot pilot = new Pilot("Test", "United States");
        return localFlightGenerator.createLocalFlight(pilot, DefaultPlanes.c152);
    }
}
