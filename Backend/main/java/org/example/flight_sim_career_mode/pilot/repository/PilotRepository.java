package org.example.flight_sim_career_mode.pilot.repository;

import org.example.flight_sim_career_mode.pilot.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, String> {
}
