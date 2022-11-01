package org.example.flight_sim_career_mode.flightgenerator;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.example.flight_sim_career_mode.pilot.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/flight")
@AllArgsConstructor
public class FlightController {

    @Autowired
    private final GenerateFlight generateFlight;
    @Autowired
    private final FlightService flightService;
    @Autowired
    private final PilotService pilotService;

    @RequestMapping(value = "/get")
    public Flight getRandomFlight(){
        Flight flight = generateFlight.createFlight(pilotService.findPilotByName("Name"));
        flightService.saveFlight(flight);
        return flight;
    }
}
