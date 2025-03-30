package org.example.appapi.service;

import org.example.querymodule.projection.LicenseProjection;
import org.example.querymodule.repository.LicenseProjectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseQueryService {
    private final LicenseProjectionRepository repository;

    public LicenseQueryService(LicenseProjectionRepository repository) {
        this.repository = repository;
    }

    public LicenseProjection getLicenseById(String licenseId) {
        return repository.findByLicenseId(licenseId);
    }

    public List<LicenseProjection> getLicensesByUser(String issuedTo) {
        return repository.findByIssuedTo(issuedTo);
    }
}