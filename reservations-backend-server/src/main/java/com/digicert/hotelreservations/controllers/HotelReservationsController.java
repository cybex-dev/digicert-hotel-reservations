package com.digicert.hotelreservations.controllers;

import com.digicert.hotelreservations.exceptions.ReservationNotFoundException;
import com.digicert.hotelreservations.models.RESTDataResponse;
import com.digicert.hotelreservations.models.Reservation;
import com.digicert.hotelreservations.repository.HotelReservationsRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Path("reservations")
public class HotelReservationsController {

    private HotelReservationsRepository hotelReservationsRepository;

    @Autowired
    public HotelReservationsController(HotelReservationsRepository hotelReservationsRepository) {
        this.hotelReservationsRepository = hotelReservationsRepository;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response greeting() {
        return Response.ok("Hello").build();
    }

    /**
     * Get all reservations
     *
     * @return list of reservations
     */
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        Iterable<Reservation> results = hotelReservationsRepository.findAll();
        results.forEach(reservations::add);

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("count", reservations.size());
        return Response.ok(new RESTDataResponse<>(true, reservations, metadata)).build();
    }

    /**
     * Get a reservation by id
     *
     * @param id reservation id
     * @return reservation object or 404 if not found
     */
    @GET
    @Path("get/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getReservation(@PathParam("id") long id) {
        Optional<Reservation> reservation = hotelReservationsRepository.findById(id);
        reservation.orElseThrow(() -> new ReservationNotFoundException(id));
        return Response.ok(reservation).build();
    }

    /**
     * Create a reservation
     *
     * @param reservation reservation object
     * @return 200 if successful
     */
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createReservation(Reservation reservation) {
        // check:
        // - has room got reservation at the same time
        // - has guest got reservation at the same time
        // - else create reservation
        Reservation savedReservation = hotelReservationsRepository.save(reservation);
        return Response.ok(new RESTDataResponse<>(true, savedReservation)).build();
    }

    /**
     * Update a reservation
     *
     * @param id          reservation id
     * @param reservation reservation object
     * @return 200 if successful
     */
    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateReservation(@PathParam("id") long id, Reservation reservation) {
        reservation.setId(id);
        Optional<Reservation> current = hotelReservationsRepository.findById(id);
        current.orElseThrow(() -> new ReservationNotFoundException(id));

        if (current.get().equals(reservation)) {
            return Response.ok(new RESTDataResponse<>(true, "No details changed, reservation " + id + " not updated")).build();
        }

        // check:
        // - has room got reservation at the same time
        // - has guest got reservation at the same time
        // - else create reservation
        hotelReservationsRepository.save(reservation);
        return Response.ok(new RESTDataResponse<>(true, "Reservation " + id + " updated")).build();
    }

    /**
     * Delete a reservation
     *
     * @param id reservation id
     * @return 200 if successful
     */
    @DELETE
    @Path("delete/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteReservation(@PathParam("id") long id) {
        if (!hotelReservationsRepository.existsById(id)) {
            throw new ReservationNotFoundException(id);
        }
        hotelReservationsRepository.deleteById(id);
        return Response.ok(new RESTDataResponse<>(true, "Reservation " + id + " deleted")).build();
    }

}
