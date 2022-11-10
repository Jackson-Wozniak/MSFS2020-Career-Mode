package org.example.flight_sim_career_mode.flight.airport.repository;

import org.example.flight_sim_career_mode.flight.airport.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
