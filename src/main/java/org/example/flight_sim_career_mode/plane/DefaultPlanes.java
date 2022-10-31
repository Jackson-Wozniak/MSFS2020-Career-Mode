package org.example.flight_sim_career_mode.plane;

import org.example.flight_sim_career_mode.pilot.enums.License;

import java.util.ArrayList;
import java.util.List;

public class DefaultPlanes {

    private static final List<Plane> propellerPlanes = List.of(
            new Plane("Cessna 152", 120, 477, PlaneType.PROPELLER)
    );

    private static final List<Plane> turboPropPlanes = List.of(
            new Plane("TBM Daher 930", 330, 989, PlaneType.TURBOPROP)
    );

    private static final List<Plane> jetPlanes = List.of(

    );

    private static final List<Plane> airliners = List.of(
            new Plane("Airbus A320", 350, 3300, PlaneType.AIRLINER)
    );


    public static List<Plane> getPlanesByLicense(License license){
        List<Plane> planes = new ArrayList<>(propellerPlanes);
        switch (license){
            case LOCAL_PILOT:
                return planes;
            case PRO_PILOT:
                planes.addAll(turboPropPlanes);
                return planes;
            case COMMERCIAL_PILOT:
                planes.addAll(turboPropPlanes);
                planes.addAll(airliners);
                return planes;
            default :
                return List.of();
        }
    }
}