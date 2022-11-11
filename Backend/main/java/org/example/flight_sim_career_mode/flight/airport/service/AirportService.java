package org.example.flight_sim_career_mode.flight.airport.service;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.flight.airport.entity.Airport;
import org.example.flight_sim_career_mode.flight.airport.exception.AirportException;
import org.example.flight_sim_career_mode.flight.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirportService {

    @Autowired
    private final AirportRepository airportRepository;

    public void saveAllAirports(List<Airport> airports){
        airportRepository.saveAll(airports);
    }

    public Airport findAirportByIcao(String icaoCode){
        return airportRepository.findById(icaoCode)
                .orElseThrow(() -> new AirportException("Airport not found"));
    }

    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }

    public Airport findRandomAirport(){
        return airportRepository.findRandomAirport();
    }

    public List<Airport> findAllAirportsBySize(String size){
        return airportRepository.findAll().stream()
                .filter(airport -> airport.getSize().equalsIgnoreCase(size))
                .collect(Collectors.toList());
    }

    public List<Airport> findAllAirportsByCountry(String country){
        return airportRepository.findAll().stream()
                .filter(airport -> airport.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    public long findDatabaseRowCount(){
        return airportRepository.count();
    }
}
