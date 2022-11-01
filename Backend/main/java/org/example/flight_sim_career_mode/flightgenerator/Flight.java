package org.example.flight_sim_career_mode.flightgenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.airport.entity.Airport;
import org.example.flight_sim_career_mode.pilot.model.entity.Pilot;
import org.example.flight_sim_career_mode.plane.Plane;

import javax.persistence.*;

@Entity(name = "flight")
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_icao")
    private Airport departure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_icao")
    private Airport destination;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_name")
    private Pilot pilot;

    @Embedded
    private Plane plane;

    @Column(name = "story")
    private String story;

    @Column(name = "flight_time")
    private String flightTime;

    @Column(name = "flight_distance")
    private Double flightDistance;

    @Column(name = "payout")
    private Double payout;

    public Flight(Airport departure,
                  Airport destination,
                  Pilot pilot,
                  Plane plane,
                  String story) {
        this.departure = departure;
        this.destination = destination;
        this.pilot = pilot;
        this.plane = plane;
        this.story = story;
        this.flightDistance = GenerateFlightUtils.calculateFlightDistanceInMiles(departure, destination);
        this.flightTime = GenerateFlightUtils.convertHoursToHHmm(
                GenerateFlightUtils.calculateFlightHours(plane.getPlaneSpeedInKnots(), this.flightDistance));
        this.payout = FlightPayoutCalculator.findFlightPayout(flightTime, pilot.getLicense());
    }
}
