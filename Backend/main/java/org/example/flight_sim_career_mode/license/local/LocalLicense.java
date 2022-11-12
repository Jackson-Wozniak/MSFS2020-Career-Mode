package org.example.flight_sim_career_mode.license.local;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.pilot.model.Pilot;

import javax.persistence.*;

/*
Entity to track the progress of the local license path for pilots.
Each pilot completes flights that will add to the payout, and can
buy/rent new planes to complete more flights with
 */
@Entity(name = "LocalLicense")
@Table(name = "local_license")
@Getter
@Setter
@NoArgsConstructor
public class LocalLicense {

    @Id
    private String name;

    @MapsId
    @OneToOne
    @JoinColumn(name = "name")
    private Pilot pilot;

    @Column(name = "local_reputation")
    private Integer reputation;

    @Column(name = "balance")
    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_mission")
    private LocalFlight currentFlight;

    public LocalLicense(Pilot pilot) {
        this.pilot = pilot;
        this.reputation = 0;
        this.balance = 0.0;
        this.currentFlight = new LocalFlight();
    }
}
