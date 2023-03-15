package com.digicert.hotelreservations.config;

import com.digicert.hotelreservations.controllers.HotelSiteController;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(HotelSiteController.class);
    }
}
