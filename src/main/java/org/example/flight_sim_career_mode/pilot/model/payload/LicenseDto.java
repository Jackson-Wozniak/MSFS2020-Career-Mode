package org.example.flight_sim_career_mode.pilot.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.flight_sim_career_mode.pilot.enums.License;
import org.example.flight_sim_career_mode.plane.Plane;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LicenseDto {

    private License license;
    private double price;
    private List<Plane> availablePlanes;
}
