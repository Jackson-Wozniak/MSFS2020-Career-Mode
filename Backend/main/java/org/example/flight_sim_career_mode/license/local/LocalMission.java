package org.example.flight_sim_career_mode.license.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LocalMission {

    @Embedded
    private Cargo cargo;

    private Integer weightOfCargo;

    private String missionStory;

    private Double payout;
}
