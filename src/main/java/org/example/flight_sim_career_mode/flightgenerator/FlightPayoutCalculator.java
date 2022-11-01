package org.example.flight_sim_career_mode.flightgenerator;

import org.example.flight_sim_career_mode.pilot.enums.License;

public class FlightPayoutCalculator {

    //find flight payout based on flight hours multiplied by license hourly payout.
    public static double findFlightPayout(String flightTime, License license){
        int flightHours = Integer.parseInt(flightTime.split(":")[0]);
        return flightHours * license.getHourlyPayout();
    }
}
