package org.example.commandmodule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "event_store")
@Getter
@Setter
@NoArgsConstructor
public class StoredEvent {
    public StoredEvent(String aggregateId, String eventType, String payload) {
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aggregateId;

    private String eventType;

    @Column(name = "json_data", columnDefinition = "text")
    private String payload;

    private LocalDateTime occurredAt = LocalDateTime.now();
}