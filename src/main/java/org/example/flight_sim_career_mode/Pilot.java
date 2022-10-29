package org.example.flight_sim_career_mode;

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

    @Column(name = "license")
    private License license;

    @Column(name = "balance")
    private Double balance;
}
