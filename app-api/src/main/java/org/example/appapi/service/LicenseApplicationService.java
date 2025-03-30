package org.example.appapi.service;

import lombok.RequiredArgsConstructor;
import org.example.commandmodule.handler.CommandHandler;
import org.example.commonmodule.command.CreateLicenseCommand;
import org.example.commonmodule.dto.LicenseEvent;
import org.example.commonmodule.dto.LicenseEvent;
import org.example.querymodule.handler.LicenseProjectionHandler;
import org.springframework.stereotype.Service;

@Service
public class LicenseApplicationService {

    private final CommandHandler<CreateLicenseCommand, LicenseEvent> commandHandler;
    private final LicenseProjectionHandler projectionHandler;

    public LicenseApplicationService(CommandHandler<CreateLicenseCommand, LicenseEvent> commandHandler,
                                     LicenseProjectionHandler projectionHandler) {
        this.commandHandler = commandHandler;
        this.projectionHandler = projectionHandler;
        
    }

    public void createLicenseEvent(CreateLicenseCommand command) {
        LicenseEvent event = commandHandler.handle(command);
        projectionHandler.on(event);
    }
}