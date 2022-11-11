package org.example.flight_sim_career_mode.license.local;

import org.example.flight_sim_career_mode.flight.airport.entity.Airport;
import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.Route;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LocalMissionStories {

    private static final Random random = new Random();
    private static final File cdsFile = new File("Text_Files/stories/local/cds.txt");

    /*
    Formatting:
        1st. Company Name
        2nd. Cargo weight
        3rd. Cargo material
        4th. Departure Name
        5th. Destination Name
        6th. Plane Name
        7th. Flight Distance
        8th. Flight Time
     */
    private static final List<String> localStories = List.of(
            "{company} is looking at you to fly {cargoWeight} pounds of {cargoMaterial}" +
                    " from {departureAirport} to {destinationAirport}. You will be flying the {planeName} a" +
                    " total distance of {distance} miles, and will be in the air for approximately {time}"
    );

    public static String findRandomStory(Cargo cargo, int cargoWeight, Route route, Plane plane) throws IOException {
        String story = findMissionStory(Files.readAllLines(cdsFile.toPath()));
        story = story.replace("{company}", Companies.getRandomCompanyName());
        story = story.replace("{cargoWeight}", String.valueOf(cargoWeight));
        story = story.replace("{cargoMaterial}", cargo.getMaterials());
        story = story.replace("{departure}", route.getDeparture().getAirportName());
        story = story.replace("{destination}", route.getDestination().getAirportName());
        story = story.replace("{plane}", plane.getName());
        story = story.replace("{distance}", String.valueOf(route.getFlightDistance()));
        story = story.replace("{time}", route.getFlightTime());
        return story;
    }

    public static String findMissionStory(List<String> lines){
        return lines.get(random.nextInt(lines.size()));
    }
}
