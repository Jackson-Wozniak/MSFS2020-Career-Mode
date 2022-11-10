package org.example.flight_sim_career_mode.pilot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "pilot")
@Table(name = "pilot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {

    @Id
    private String name;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "balance")
    private Double balance;

    public Pilot(String name, String countryOfOrigin){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.balance = 0.0;
    }
}
