package org.example.flight_sim_career_mode.flightgenerator;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.enums.License;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.example.flight_sim_career_mode.plane.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class GenerateFlight {

    @Autowired
    private final RouteGenerator routeGenerator;

    public Flight createFlight(Pilot pilot){
        return switch (pilot.getLicense()){
            case LOCAL_PILOT -> createLocalFlight(pilot);
            case PRO_PILOT -> createProfessionalFlight(pilot);
            case COMMERCIAL_PILOT -> createCommercialFlight(pilot);
        };
    }

    private Flight createLocalFlight(Pilot pilot){
        Plane plane = GenerateFlightUtils.getRandomPlaneByLicense(License.LOCAL_PILOT);
        return routeGenerator.createLocalFlightRoute(plane, pilot);
    }

    private Flight createProfessionalFlight(Pilot pilot){
        Plane plane = GenerateFlightUtils.getRandomPlaneByLicense(License.PRO_PILOT);
        return routeGenerator.createProFlightRoute(plane, pilot);
    }

    private Flight createCommercialFlight(Pilot pilot){
        Plane plane = GenerateFlightUtils.getRandomPlaneByLicense(License.COMMERCIAL_PILOT);
        return routeGenerator.createCommercialFlightRoute(plane, pilot);
    }
}
