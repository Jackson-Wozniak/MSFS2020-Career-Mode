package org.example.flight_sim_career_mode.license.local;

import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.GenerateRouteUtils;
import org.example.flight_sim_career_mode.flight.route.Route;
import org.example.flight_sim_career_mode.flight.route.RouteGenerator;

import java.text.DecimalFormat;

public class PayoutCalculator {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static double getFlightPayout(LocalMission localMission, double flightHours){
        return Double.parseDouble(decimalFormat.format(localMission.getWeightOfCargo()
                * flightHours
                * localMission.getCargo().getPayoutMultiplier()
        ));
    }
}
