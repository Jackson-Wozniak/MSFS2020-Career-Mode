package org.example.flight_sim_career_mode.pilot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.flight_sim_career_mode.license.local.LocalLicense;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pilot")
@Table(name = "pilot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilot implements Serializable {

    @Id
    private String name;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "balance")
    private Double balance;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pilot")
    private LocalLicense localLicense;

    public Pilot(String name, String countryOfOrigin){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.balance = 0.0;
    }
}
