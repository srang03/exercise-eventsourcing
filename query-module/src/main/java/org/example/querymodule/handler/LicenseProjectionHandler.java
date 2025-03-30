package org.example.querymodule.handler;

import org.example.commonmodule.dto.LicenseEvent;

public interface LicenseProjectionHandler {
    void on(LicenseEvent event);
}
