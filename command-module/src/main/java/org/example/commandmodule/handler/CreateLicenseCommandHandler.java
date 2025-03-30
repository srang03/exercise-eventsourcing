package org.example.commandmodule.handler;

import org.example.commandmodule.aggregate.LicenseAggregate;
import org.example.commandmodule.mapper.LicenseMapper;
import org.example.commandmodule.store.EventStore;
import org.example.commonmodule.command.CreateLicenseCommand;
import org.example.commonmodule.dto.LicenseEvent;
import org.springframework.stereotype.Service;

@Service
public class CreateLicenseCommandHandler implements CommandHandler<CreateLicenseCommand, LicenseEvent> {
    private final EventStore eventStore;
    private final LicenseMapper mapper;

    public CreateLicenseCommandHandler(EventStore eventStore, LicenseMapper mapper) {
        this.eventStore = eventStore;
        this.mapper = mapper;
    }

    @Override
    public LicenseEvent handle(CreateLicenseCommand command) {
        LicenseAggregate aggregate = mapper.toAggregate(command);

        LicenseEvent event = new LicenseEvent(
                aggregate.licenseId(),
                aggregate.productKey(),
                aggregate.licenseType(),
                aggregate.issuedTo(),
                command.action(), // ← 여기서 직접 넣음
                aggregate.validFrom(),
                aggregate.validUntil(),
                aggregate.status().name() // enum → string
        );

        eventStore.saveEvent(command.licenseId(), event);
        return event;
    }
}
