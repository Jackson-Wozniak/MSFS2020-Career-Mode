package org.example.flight_sim_career_mode.pilot.service;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.exception.PilotAlreadyCreatedException;
import org.example.flight_sim_career_mode.pilot.exception.PilotNotFoundException;
import org.example.flight_sim_career_mode.pilot.repository.PilotRepository;
import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PilotService {

    @Autowired
    private final PilotRepository pilotRepository;

    public Pilot findPilotByName(String name){
        return pilotRepository.findById(name).orElseThrow(
                () -> new PilotNotFoundException("Pilot Does Not Exist"));
    }

    public void updatePilot(Pilot pilot){
        pilotRepository.save(pilot);
    }

    public void saveNewPilot(Pilot pilot){
        if(pilotExistsByName(pilot.getName())){
            throw new PilotAlreadyCreatedException("New Pilot cannot be created with existing name");
        }
        pilotRepository.save(pilot);
    }

    public boolean pilotExistsByName(String name){
        try{
            findPilotByName(name);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
