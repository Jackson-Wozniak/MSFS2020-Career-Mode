package org.example.flight_sim_career_mode.flight.plane;

import java.util.ArrayList;
import java.util.List;

public class DefaultPlanes {

    public static final Plane c152 = new Plane("Cessna 152", 120, 477, PlaneType.PROPELLER, 415);

    private static final List<Plane> turboPropPlanes = List.of(
            new Plane("TBM Daher 930", 330, 989, PlaneType.TURBOPROP, 415)
    );

    private static final List<Plane> jetPlanes = List.of(

    );

    private static final List<Plane> airliners = List.of(
            new Plane("Airbus A320", 350, 3300, PlaneType.AIRLINER, 415)
    );
}
