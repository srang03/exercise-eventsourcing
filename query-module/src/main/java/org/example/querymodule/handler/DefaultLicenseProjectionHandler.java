package org.example.querymodule.handler;

import org.example.commonmodule.dto.LicenseEvent;
import org.example.querymodule.mapper.LicenseProjectionMapper;
import org.example.querymodule.projection.LicenseProjection;
import org.example.querymodule.repository.LicenseProjectionRepository;
import org.springframework.stereotype.Component;

@Component
public class DefaultLicenseProjectionHandler implements LicenseProjectionHandler{
    private final LicenseProjectionMapper mapper;
    private final LicenseProjectionRepository repository;

    public DefaultLicenseProjectionHandler(LicenseProjectionMapper mapper, LicenseProjectionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public void on(LicenseEvent event) {
        LicenseProjection projection = mapper.toProjection(event);
        repository.save(projection);
    }
}
