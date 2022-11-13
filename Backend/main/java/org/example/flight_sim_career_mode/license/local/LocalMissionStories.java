package org.example.flight_sim_career_mode.license.local;

import org.example.flight_sim_career_mode.flight.plane.Plane;
import org.example.flight_sim_career_mode.flight.route.Route;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class LocalMissionStories {

    private static final Random random = new Random();
    private static final File cdsFile = new File("Text_Files/stories/local/CDs.txt");
    private static final File steelFile = new File("Text_Files/stories/local/Steel.txt");
    private static final File lumberFile = new File("Text_Files/stories/local/Lumber.txt");
    private static final File foodFile = new File("Text_Files/stories/local/Food.txt");
    private static final File phoneFile = new File("Text_Files/stories/local/Phone.txt");
    private static final File goldFile = new File("Text_Files/stories/local/Gold.txt");
    private static final File microchipFile = new File("Text_Files/stories/local/Microchip.txt");
    private static final File heavyMachineryFile = new File("Text_Files/stories/local/HeavyMachinery.txt");
    private static final File noCargoFile = new File("Text_Files/stories/local/NoCargo.txt");

    //replace variables in file with string values based on generated story
    public static String findRandomStory(Cargo cargo, int cargoWeight, Route route, Plane plane) throws IOException {
        String story = findMissionStory(
                Files.readAllLines(findFileByMaterials(cargo.getMaterials()).toPath()));
        return replaceTextVariablesWithValues(story, cargo, cargoWeight, route, plane);
    }

    public static File findFileByMaterials(String materials){
        return switch (materials.toUpperCase()){
            case "STEEL" -> steelFile;
            case "CDS" -> cdsFile;
            case "LUMBER" -> lumberFile;
            case "FOOD" -> foodFile;
            case "PHONES" -> phoneFile;
            case "GOLD" ->  goldFile;
            case "MICROCHIPS" -> microchipFile;
            case "HEAVY_MACHINERY" -> heavyMachineryFile;
            default -> noCargoFile;
        };
    }

    public static String findMissionStory(List<String> lines){
        if(lines.size() == 0){
            return "";
        }
        return lines.get(random.nextInt(lines.size()));
    }

    public static String replaceTextVariablesWithValues(
            String story, Cargo cargo, int cargoWeight, Route route, Plane plane){
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
}
