package org.example.flight_sim_career_mode.airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AirportException extends RuntimeException{

    public AirportException(String message){
        super(message);
    }
}
