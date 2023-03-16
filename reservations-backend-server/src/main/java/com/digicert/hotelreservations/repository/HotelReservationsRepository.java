package com.digicert.hotelreservations.repository;

import com.digicert.hotelreservations.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelReservationsRepository extends CrudRepository<Reservation, Long> {}
