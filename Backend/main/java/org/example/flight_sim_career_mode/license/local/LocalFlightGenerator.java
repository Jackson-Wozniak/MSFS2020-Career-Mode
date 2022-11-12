package org.example.flight_sim_career_mode.license.local;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.entity.Airport;
import org.example.flight_sim_career_mode.flight.airport.service.AirportService;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.RouteGenerator;
import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

//A class to generate the routes for local flights
//LocalMissionGenerator.java is used to generate the mission context for these flights
@Component
@AllArgsConstructor
public class LocalFlightGenerator {

    @Autowired
    private final AirportService airportService;
    @Autowired
    private final RouteGenerator routeGenerator;
    @Autowired
    private final LocalMissionGenerator localMissionGenerator;

    public LocalFlight createLocalFlight(Pilot pilot, Plane plane) throws IOException {
        LocalFlight currentFlight = new LocalFlight();
        List<Airport> countryOfOriginAirports =
                airportService.findAllAirportsByCountry(pilot.getCountryOfOrigin());
        if(countryOfOriginAirports.size() < 5){
            countryOfOriginAirports = airportService.findAllAirports();
        }
        currentFlight.setPlane(plane);
        currentFlight.setRoute(routeGenerator.createDomesticFlight(
                plane, pilot.getCountryOfOrigin(), 5));
        currentFlight.setLocalMission(
                localMissionGenerator.createLocalMission(currentFlight.getRoute(), plane));
        return currentFlight;
    }
}
