package org.example.flight_sim_career_mode.pilot.controller;

import lombok.AllArgsConstructor;
import org.example.flight_sim_career_mode.pilot.model.payload.LicenseDto;
import org.example.flight_sim_career_mode.pilot.service.PilotService;
import org.example.flight_sim_career_mode.pilot.model.payload.UpgradeLicenseRequest;
import org.example.flight_sim_career_mode.pilot.enums.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/license")
@AllArgsConstructor
public class LicenseController {

    @Autowired
    private final PilotService pilotService;

    @RequestMapping
    public List<LicenseDto> findAllLicenseAvailable(){
        return List.of(
                License.LOCAL_PILOT.createDtoByLicense(),
                License.PRO_PILOT.createDtoByLicense(),
                License.COMMERCIAL_PILOT.createDtoByLicense()
        );
    }

    @PostMapping(value = "/upgrade")
    public void upgradePilotLicense(@RequestBody UpgradeLicenseRequest upgradeLicenseRequest){
        pilotService.upgradePilotLicense(
                pilotService.findPilotByName(upgradeLicenseRequest.getPilotName()),
                License.valueOf(upgradeLicenseRequest.getLicenseUpgrade().toUpperCase())
        );
    }
}
