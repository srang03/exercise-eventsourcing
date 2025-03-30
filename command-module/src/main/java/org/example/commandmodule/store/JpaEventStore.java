package org.example.commandmodule.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.commandmodule.entity.StoredEvent;
import org.springframework.stereotype.Component;

@Component
public class JpaEventStore implements EventStore {
    private final ObjectMapper objectMapper;
    private final StoredEventRepository repository;

    public JpaEventStore(ObjectMapper objectMapper, StoredEventRepository repository) {
        this.objectMapper = objectMapper;
        this.repository = repository;
    }

    @Override
    public <T> void saveEvent(String aggregateId, T event) {
        try {
            String payload = objectMapper.writeValueAsString(event);

            StoredEvent stored = new StoredEvent(
                    aggregateId,
                    event.getClass().getSimpleName(),
                    payload
            );
            repository.save(stored);
            // log.info("Event stored: {}", stored.getEventType());
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }
}