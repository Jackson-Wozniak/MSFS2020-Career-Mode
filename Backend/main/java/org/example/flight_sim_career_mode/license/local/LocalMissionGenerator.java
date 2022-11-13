package org.example.flight_sim_career_mode.license.local;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.GenerateRouteUtils;
import org.example.flight_sim_career_mode.flight.route.Route;
import org.springframework.stereotype.Component;

import java.io.IOException;

//Generate a random mission for local flights
@Component
@AllArgsConstructor
public class LocalMissionGenerator {

    public LocalMission createLocalMission(Route route, Plane plane) throws IOException {
        LocalMission localMission = new LocalMission();
        localMission.setCargo(DefaultCargo.getRandomCargoMaterial());
        localMission.setWeightOfCargo(DefaultCargo.getRandomCargoWeight(plane));
        localMission.setPayout(PayoutCalculator.getFlightPayout(localMission,
                GenerateRouteUtils.calculateFlightHours(
                        plane.getPlaneSpeedInKnots(), route.getFlightDistance())));
        localMission.setMissionStory(
            LocalMissionStories.findRandomStory(
                    localMission.getCargo(),
                    localMission.getWeightOfCargo(),
                    route,
                    plane)
        );
        return localMission;
    }
}
