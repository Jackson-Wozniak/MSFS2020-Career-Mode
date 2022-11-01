package org.example.flight_sim_career_mode.flightgenerator;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.airport.entity.Airport;
import org.example.flight_sim_career_mode.airport.service.AirportService;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.example.flight_sim_career_mode.plane.Plane;
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

    public Flight createLocalFlightRoute(Plane plane, Pilot pilot){
        boolean validFlight;
        List<Airport> airports = airportService.findAllAirportsByCountry(pilot.getCountryOfOrigin());
        if(airports.size() <= 0) {
            throw new RuntimeException("cannot generate flight");
        }
        Airport airport1;
        Airport airport2;
        do{
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));

            //flight must be under 8 hours
            validFlight = GenerateFlightUtils.calculateFlightHours(
                    plane.getPlaneSpeedInKnots(),
                    GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2)) < 5.0;
        }while (!validFlight);

        return new Flight(airport1, airport2, pilot, plane, "Story");
    }

    public Flight createProFlightRoute(Plane plane, Pilot pilot){
        boolean validFlight;
        List<Airport> airports = airportService.findAllAirports();
        Airport airport1;
        Airport airport2;
        do{
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));

            //flight must be under 8 hours
            validFlight = GenerateFlightUtils.calculateFlightHours(
                    plane.getPlaneSpeedInKnots(),
                    GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2)) < 5.0;
        }while (!validFlight);

        return new Flight(airport1, airport2, pilot, plane, "Story");
    }

    public Flight createCommercialFlightRoute(Plane plane, Pilot pilot){
        boolean validFlight;
        List<Airport> airports = airportService.findAllAirportsBySize("large");
        Airport airport1;
        Airport airport2;
        do{
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));

            //flight must be under 8 hours
            validFlight = GenerateFlightUtils.calculateFlightHours(
                    plane.getPlaneSpeedInKnots(),
                    GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2)) < 8.0;
        }while (!validFlight);

        return new Flight(airport1, airport2, pilot, plane, "Story");
    }
}
