package org.example.commandmodule.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public record LicenseAggregate(
        String licenseId,
        String productKey,
        String licenseType,
        String issuedTo,
        LocalDate validFrom,
        LocalDate validUntil,
        Status status
) {
    public enum Status {
        ACTIVE, REVOKED
    }
}