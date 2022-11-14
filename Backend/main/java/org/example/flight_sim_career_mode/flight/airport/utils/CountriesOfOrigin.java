package org.example.flight_sim_career_mode.flight.airport.utils;

import org.example.flight_sim_career_mode.flight.airport.entity.Airport;

import java.util.*;

public class CountriesOfOrigin {

    //return all countries with 100+ airports
    public static List<String> findCountriesWithEnoughAirports(List<Airport> airports){
        Map<String, Integer> countries = new HashMap<>();
        for(Airport airport : airports){
           String country = airport.getCountry();
           if(countries.containsKey(country)){
               countries.replace(country, countries.get(country) + 1);
           }else{
               countries.put(country, 0);
           }
        }
        List<String> validCountries = new ArrayList<>();
        for (String country : countries.keySet()) {
            if (countries.get(country) >= 100) {
                validCountries.add(country);
            }
        }
        return validCountries;
    }
}
