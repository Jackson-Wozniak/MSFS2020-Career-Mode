package org.example.flight_sim_career_mode.flight.route;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/flight")
@AllArgsConstructor
public class RouteController {

    @Autowired
    private final GenerateRoute generateFlight;
    @Autowired
    private final RouteService routeService;
    @Autowired
    private final PilotService pilotService;

    @RequestMapping(value = "/get")
    public Route getRandomFlight(){
        Route route = generateFlight.createFlight(pilotService.findPilotByName("Name"));
        routeService.saveFlight(route);
        return route;
    }
}
