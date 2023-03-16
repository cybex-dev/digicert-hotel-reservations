package com.digicert.hotelreservations.controllers;

import com.digicert.hotelreservations.exceptions.ReservationNotFoundException;
import com.digicert.hotelreservations.models.RESTDataResponse;
import com.digicert.hotelreservations.models.Reservation;
import com.digicert.hotelreservations.repository.HotelReservationsRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     *
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
        // TODO check reservation dates
//        Optional<Reservation> byRoomNumber = hotelReservationsRepository.findByRoomNumber(1);
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
