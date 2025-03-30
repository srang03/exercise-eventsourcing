package org.example.commandmodule.store;

import org.example.commandmodule.entity.StoredEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredEventRepository extends JpaRepository<StoredEvent, Long> {
}