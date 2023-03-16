package com.digicert.hotelreservations.exceptions;

import com.digicert.hotelreservations.models.RESTErrorResponse;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ReservationNotFoundException extends WebApplicationException {
    public ReservationNotFoundException(Long id) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(new RESTErrorResponse("not-found", "Reservation " + id + " not found"))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }
}
