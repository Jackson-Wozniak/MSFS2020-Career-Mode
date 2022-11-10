package org.example.flight_sim_career_mode.flight.route;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.enums.License;
import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenerateRoute {

    @Autowired
    private final RouteGenerator routeGenerator;

    public Route createFlight(Pilot pilot){
        return switch (pilot.getLicense()){
            case LOCAL_PILOT -> createLocalFlight(pilot);
            case PRO_PILOT -> createProfessionalFlight(pilot);
            case COMMERCIAL_PILOT -> createCommercialFlight(pilot);
        };
    }

    private Route createLocalFlight(Pilot pilot){
        Plane plane = GenerateRouteUtils.getRandomPlaneByLicense(License.LOCAL_PILOT);
        return routeGenerator.createLocalFlightRoute(plane, pilot);
    }

    private Route createProfessionalFlight(Pilot pilot){
        Plane plane = GenerateRouteUtils.getRandomPlaneByLicense(License.PRO_PILOT);
        return routeGenerator.createProFlightRoute(plane, pilot);
    }

    private Route createCommercialFlight(Pilot pilot){
        Plane plane = GenerateRouteUtils.getRandomPlaneByLicense(License.COMMERCIAL_PILOT);
        return routeGenerator.createCommercialFlightRoute(plane, pilot);
    }
}
