package org.example.commonmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

public record LicenseEvent(
        String licenseId,
        String productKey,
        String licenseType,
        String issuedTo,
        String action,
        LocalDate validFrom,
        LocalDate validUntil,
        String status // 문자열 타입 유지
) {
    private static final Set<String> VALID_ACTIONS = Set.of("CREATE", "UPDATE", "DELETE");
    public LicenseEvent {
        if (!VALID_ACTIONS.contains(action.toUpperCase())) {
            throw new IllegalArgumentException("Invalid action: " + action);
        }
    }
}