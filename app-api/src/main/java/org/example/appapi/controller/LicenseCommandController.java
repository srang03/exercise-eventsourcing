package org.example.appapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.appapi.service.LicenseApplicationService;
import org.example.commonmodule.command.CreateLicenseCommand;
import org.example.querymodule.projection.LicenseProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseCommandController {

    private final LicenseApplicationService applicationService;

     public LicenseCommandController(LicenseApplicationService applicationService) {
         this.applicationService = applicationService;
     }

    @PostMapping
    public ResponseEntity<String> createLicense(@RequestBody CreateLicenseCommand command) {
        applicationService.createLicenseEvent(command);
        return ResponseEntity.ok("License created");
    }

    @PatchMapping
    public ResponseEntity<String> updateLicense(@RequestBody CreateLicenseCommand command) {
        applicationService.createLicenseEvent(command);
        return ResponseEntity.ok("License updated");
    }
}