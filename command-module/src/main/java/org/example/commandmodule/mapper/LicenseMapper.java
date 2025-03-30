package org.example.commandmodule.mapper;

import org.example.commandmodule.aggregate.LicenseAggregate;
import org.example.commonmodule.command.CreateLicenseCommand;
import org.example.commonmodule.dto.LicenseEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LicenseMapper {

    LicenseAggregate toAggregate(CreateLicenseCommand command);

    LicenseEvent toEvent(LicenseAggregate aggregate);
}