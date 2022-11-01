package org.example.flight_sim_career_mode.plane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.plane.PlaneType;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Plane {

    private String name;
    private Integer planeSpeedInKnots;
    private Integer rangeInMiles;
    private PlaneType planeType;
}
