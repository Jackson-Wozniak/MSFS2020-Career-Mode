package org.example.flight_sim_career_mode.license.local;

import org.example.flight_sim_career_mode.flight.plane.Plane;

import java.util.List;
import java.util.Random;

public class DefaultCargo {

    private static final Random random = new Random();
    private static final List<Cargo> cargo = List.of(
        new Cargo("Steel", 1.4),
        new Cargo("CDs", 1.2),
        new Cargo("Lumber", 1.1),
        new Cargo("Food", 1.1),
        new Cargo("Phones", 1.4),
        new Cargo("Gold", 1.9),
        new Cargo("Microchips", 1.7),
        new Cargo("Heavy_Machinery", 1.3),
        //none is used for connecting/travel flights that do not give payout
        new Cargo("No_Cargo", 0.0)
    );

    public static Cargo getRandomCargoMaterial(){
        return cargo.get(random.nextInt(cargo.size()));
    }

    public static int getRandomCargoWeight(Plane plane){
        return random.nextInt(0, plane.getCargoCapacity());
    }
}
