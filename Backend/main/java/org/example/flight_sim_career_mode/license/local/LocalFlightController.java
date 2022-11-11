package org.example.flight_sim_career_mode.license.local;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.service.AirportService;
import org.example.flight_sim_career_mode.flight.plane.DefaultPlanes;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.Route;
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

    @RequestMapping()
    public LocalFlight createLocalFlight() throws IOException {
        Route route = new Route(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                DefaultPlanes.c152.getPlaneSpeedInKnots());
        Cargo cargo = DefaultCargo.steel;
        Plane plane = DefaultPlanes.c152;
        return new LocalFlight(
                plane,
                new LocalMission(
                        cargo,
                        1000,
                        LocalMissionStories.findRandomStory(cargo, 1000, route, plane),
                        1000 * cargo.getPayoutMultiplier()),
                route
        );
    }
}
