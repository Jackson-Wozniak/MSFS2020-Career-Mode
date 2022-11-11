package org.example.flight_sim_career_mode.license.local;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.Route;

import javax.persistence.*;

@Entity(name = "local_flight")
@Table(name = "local_flight")
@Getter
@Setter
@NoArgsConstructor
public class LocalFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;

    @Embedded
    private Plane plane;

    @Embedded
    private LocalMission localMission;

    @Embedded
    private Route route;

    public LocalFlight(Plane plane, LocalMission localMission, Route route) {
        this.plane = plane;
        this.localMission = localMission;
        this.route = route;
    }
}
