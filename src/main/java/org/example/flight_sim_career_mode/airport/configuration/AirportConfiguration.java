package org.example.flight_sim_career_mode.airport.configuration;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.airport.entity.Airport;
import org.example.flight_sim_career_mode.airport.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class AirportConfiguration {

    @Autowired
    private final AirportService airportService;

    private final Logger logger = LoggerFactory.getLogger(AirportConfiguration.class);
    private static final File airportFile = new File("Text_Files/airports.csv");

    @PostConstruct
    public void findDatabaseSizeOnStartup(){
        if(airportService.findDatabaseRowCount() < 9000){
            logger.info("Saving Airports");
            try{
                airportService.saveAllAirports(convertCsvLinesToAirports(airportFile));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        logger.info("Airport DB Row Count: " + getAirportRowCount());
    }

    //these methods are used mainly for testing
    private Long getAirportRowCount(){
        return airportService.findDatabaseRowCount();
    }

    //map formatted airport lines in csv to airport objects
    public static List<Airport> convertCsvLinesToAirports(File file) throws IOException {
        return Files.lines(file.toPath())
                .map(airport -> {
                    airport = airport.replace("\"", "");
                    String[] airportColumns = airport.split(",");
                    return new Airport(
                            airportColumns[0],
                            airportColumns[1],
                            airportColumns[2],
                            //save latitude as double
                            Double.parseDouble(airportColumns[3]),
                            //save longitude as double
                            Double.parseDouble(airportColumns[4]),
                            airportColumns[5],
                            airportColumns[6]);
                }).collect(Collectors.toList());
    }
}