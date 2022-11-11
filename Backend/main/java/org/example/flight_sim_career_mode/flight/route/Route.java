package org.example.flight_sim_career_mode.flight.route;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.flight.airport.entity.Airport;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Route {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure")
    private Airport departure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination")
    private Airport destination;

    private String flightTime;

    private Double flightDistance;

    public Route(Airport departure,
                 Airport destination,
                 int planeSpeed) {
        this.departure = departure;
        this.destination = destination;
        this.flightDistance = GenerateRouteUtils.calculateFlightDistanceInMiles(departure, destination);
        this.flightTime = GenerateRouteUtils.convertHoursToHHmm(
                GenerateRouteUtils.calculateFlightHours(planeSpeed, this.flightDistance));
    }
}
