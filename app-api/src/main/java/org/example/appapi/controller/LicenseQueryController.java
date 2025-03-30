package org.example.appapi.controller;

import org.example.appapi.service.LicenseQueryService;
import org.example.querymodule.projection.LicenseProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseQueryController {

    private final LicenseQueryService queryService;

    public LicenseQueryController(LicenseQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<LicenseProjection> getLicense(@PathVariable String licenseId) {
        return ResponseEntity.ok(queryService.getLicenseById(licenseId));
    }

    @GetMapping("/issuedTo/{issuedTo}")
    public ResponseEntity<List<LicenseProjection>> getLicensesByIssuedTo(@PathVariable String issuedTo) {
        return ResponseEntity.ok(queryService.getLicensesByUser(issuedTo));
    }
}