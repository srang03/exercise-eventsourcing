package org.example.commandmodule.store;

public interface EventStore {
    <T> void saveEvent(String aggregateId, T event);
}
