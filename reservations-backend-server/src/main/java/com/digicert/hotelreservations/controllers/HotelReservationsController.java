package com.digicert.hotelreservations.controllers;

import com.digicert.hotelreservations.models.Reservation;
import com.digicert.hotelreservations.repository.HotelReservationsRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Path("reservations")
public class HotelReservationsController {

    private HotelReservationsRepository hotelReservationsRepository;

    @Autowired
    public HotelReservationsController(HotelReservationsRepository hotelReservationsRepository) {
        this.hotelReservationsRepository = hotelReservationsRepository;
    }

    /**
     * Get all reservations
     * @return list of reservations
     */
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        Iterable<Reservation> results = hotelReservationsRepository.findAll();
        results.forEach(reservations::add);
        return reservations;
    }

    /**
     * Get a reservation by id
     * @param id reservation id
     * @return reservation object or 404 if not found
     */
    @GET
    @Path("get/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getReservation(@PathParam("id") long id) {
        Reservation reservation = hotelReservationsRepository.findById(id).orElse(null);
        if(reservation == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(reservation).build();
        }

    }

    /**
     * Create a reservation
     * @param reservation reservation object
     * @return 200 if successful
     */
    @POST
    @Path("create")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response createReservation(Reservation reservation) {
        hotelReservationsRepository.save(reservation);
        return Response.ok().build();
    }

    /**
     * Update a reservation
     * @param id reservation id
     * @param reservation reservation object
     * @return 200 if successful
     */
    @PUT
    @Path("update/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response updateReservation(@PathParam("id") long id, Reservation reservation) {
        if(!hotelReservationsRepository.existsById(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            hotelReservationsRepository.save(reservation);
            return Response.ok().build();
        }
    }

    /**
     * Delete a reservation
     * @param id reservation id
     * @return 200 if successful
     */
    @DELETE
    @Path("delete/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response deleteReservation(@PathParam("id") long id) {
        hotelReservationsRepository.deleteById(id);
        return Response.ok().build();
    }

}
