package org.example.flight_sim_career_mode.pilot.controller;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.service.PilotService;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/pilot")
@AllArgsConstructor
public class PilotController {

    @Autowired
    private final PilotService pilotService;

    @RequestMapping(value = "/{name}")
    public Pilot getPilotByName(@PathVariable String name){
        return pilotService.findPilotByName(name);
    }

    @RequestMapping(value = "/create")
    public void createNewPilot(@RequestBody Pilot pilot){
        pilotService.saveNewPilot(pilot);
    }
}
