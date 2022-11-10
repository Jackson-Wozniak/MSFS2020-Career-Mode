package org.example.flight_sim_career_mode.flight.route;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.entity.Airport;
import org.example.flight_sim_career_mode.flight.airport.service.AirportService;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class RouteGenerator {

    @Autowired
    private final AirportService airportService;
    private static final Random random = new Random();

    public Route createDomesticFlight(Plane plane, String country, double maxFlightDuration){
        boolean validFlight;
        List<Airport> airports = airportService.findAllAirportsByCountry(country);
        if(airports.size() <= 0) {
            throw new RuntimeException("cannot generate flight");
        }
        Airport airport1;
        Airport airport2;
        do{
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));

            //flight must be under 8 hours
            validFlight = GenerateRouteUtils.calculateFlightHours(
                    plane.getPlaneSpeedInKnots(),
                    GenerateRouteUtils.calculateFlightDistanceInMiles(airport1, airport2)) < maxFlightDuration;
        }while (!validFlight);

        return new Route(airport1, airport2, plane.getPlaneSpeedInKnots());
    }
}
