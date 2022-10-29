package org.example.flight_sim_career_mode;

import java.util.List;

public enum License {
    LOCAL_PILOT,
    PRO_PILOT,
    COMMERCIAL_PILOT;

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
