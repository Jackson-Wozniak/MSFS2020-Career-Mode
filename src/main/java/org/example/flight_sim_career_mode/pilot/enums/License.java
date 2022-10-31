package org.example.flight_sim_career_mode.pilot.enums;

import org.example.flight_sim_career_mode.pilot.model.payload.LicenseDto;
import org.example.flight_sim_career_mode.plane.DefaultPlanes;
import org.example.flight_sim_career_mode.plane.Plane;

import java.util.List;

public enum License {
    LOCAL_PILOT,
    PRO_PILOT,
    COMMERCIAL_PILOT;

    public LicenseDto createDtoByLicense(){
        return new LicenseDto(this, this.getCostOfLicense(), this.getPlanesByLicense());
    }

    public List<Plane> getPlanesByLicense(){
        return DefaultPlanes.getPlanesByLicense(this);
    }

    public double getCostOfLicense(){
        return switch (this){
            case LOCAL_PILOT -> 0.0;
            case PRO_PILOT -> 10_000.0;
            case COMMERCIAL_PILOT -> 60_000.0;
        };
    }
}
