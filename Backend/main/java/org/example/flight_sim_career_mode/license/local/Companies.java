package org.example.flight_sim_career_mode.license.local;

import java.util.List;
import java.util.Random;

public class Companies {

    private static final Random random = new Random();

    private static final List<String> companies = List.of(
            "United States Steel Corp",
            "Greenfield Electrics",
            "Northeast Supply Co."
    );

    public static String getRandomCompanyName(){
        return companies.get(random.nextInt(companies.size()));
    }
}
