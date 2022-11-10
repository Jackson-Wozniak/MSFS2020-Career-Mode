package org.example.flight_sim_career_mode.flight.route;

import lombok.Getter;
import lombok.Setter;
import org.example.flight_sim_career_mode.flight.airport.entity.Airport;

import javax.persistence.*;

@Entity(name = "route")
@Table(name = "route")
@Getter
@Setter
@Embeddable
public class Route {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_icao")
    private Airport departure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_icao")
    private Airport destination;

    @Column(name = "flight_time")
    private String flightTime;

    @Column(name = "flight_distance")
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
