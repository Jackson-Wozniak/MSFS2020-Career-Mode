package org.example.flight_sim_career_mode.pilot.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpgradeLicenseRequest {

    private String pilotName;
    private String licenseUpgrade;
}
