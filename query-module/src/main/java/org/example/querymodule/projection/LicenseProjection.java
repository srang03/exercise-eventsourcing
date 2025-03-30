package org.example.querymodule.projection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenseProjection {
    @Id
    private String licenseId;

    private String productKey;
    private String licenseType;
    private String issuedTo;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private String status;
}