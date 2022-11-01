package org.example.flight_sim_career_mode.pilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PilotAlreadyCreatedException extends RuntimeException{

    public PilotAlreadyCreatedException(String message){
        super(message);
    }
}
