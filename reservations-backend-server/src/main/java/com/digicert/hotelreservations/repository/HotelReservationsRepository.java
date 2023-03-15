package com.digicert.hotelreservations.repository;

import com.digicert.hotelreservations.models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReservationsRepository extends CrudRepository<Reservation, Long> {}
