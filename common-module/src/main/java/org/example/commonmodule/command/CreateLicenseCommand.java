package org.example.commonmodule.command;

import java.time.LocalDate;


public record CreateLicenseCommand(
        String licenseId,
        String productKey,
        String licenseType,
        String issuedTo,
        String action,
        LocalDate validFrom,
        LocalDate validUntil,
        String status
) {
    public void validate(){
        if (licenseId == null || licenseId.isBlank()) {
            throw new IllegalArgumentException("licenseId는 필수입니다.");
        }
    }
}