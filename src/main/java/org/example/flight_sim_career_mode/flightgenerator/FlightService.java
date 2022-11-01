package org.example.flight_sim_career_mode.flightgenerator;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightService {

    @Autowired
    private final FlightRepository flightRepository;

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> findFlightByPilot(Pilot pilot){
        return flightRepository.findAll().stream()
                .filter(flight -> flight.getPilot().getName().equals(pilot.getName()))
                .collect(Collectors.toList());
    }

    public Flight findFlightById(long id){
        return flightRepository.findById(id).orElse(null);
    }
}
