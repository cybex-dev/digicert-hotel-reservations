package com.digicert.hotelreservations.config;

import com.digicert.hotelreservations.controllers.HotelReservationsController;
import com.digicert.hotelreservations.exceptions.ReservationNotFoundException;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("api")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(HotelReservationsController.class);
        register(ReservationNotFoundException.class);
    }
}
