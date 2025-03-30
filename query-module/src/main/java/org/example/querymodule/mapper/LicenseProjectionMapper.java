package org.example.querymodule.mapper;

import org.example.commonmodule.dto.LicenseEvent;
import org.example.querymodule.projection.LicenseProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface LicenseProjectionMapper {
    @Mapping(target = ".", source = "event")
    LicenseProjection toProjection(LicenseEvent event);
}