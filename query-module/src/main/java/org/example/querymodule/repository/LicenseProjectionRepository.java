package org.example.querymodule.repository;

import org.example.querymodule.projection.LicenseProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseProjectionRepository extends JpaRepository<LicenseProjection, Long> {
    List<LicenseProjection> findByIssuedTo(String issuedTo);
    LicenseProjection findByLicenseId(String licenseId);
}
