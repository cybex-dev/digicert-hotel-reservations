package com.digicert.hotelreservations.repository;

import com.digicert.hotelreservations.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * Hotel Reservations Repository extends {@link JpaRepository} to provide CRUD operations and Paging/Sort operations out of the box
 */
@Repository
public interface HotelReservationsRepository extends JpaRepository<Reservation, Long> {

    // TODO function has problem, it wont detect reservations that:
    //  - start after the checkin date and end before the checkout date         i.e |-----[reservation]-----|
    //  - start before the checkin date and end before the checkout date        i.e [   |-reservation]------|
    //  - start after the checkin date and end after the checkout date          i.e |-----[-reservation-|   ]
    /**
     * Queries reservations by room number, to find any existing reservations between {startDate} and {endDate}, returns a list of conflicting reservations
     *
     * @param roomNumber room number
     * @param startDate  start date
     * @param endDate    end date
     * @return list of conflicting reservations
     */
    @Query("SELECT r FROM Reservation r WHERE r.roomNumber = ?1 AND r.checkIn < ?3 AND r.checkOut > ?2")
    List<Reservation> checkConflictingReservationsForRoom(String roomNumber, Timestamp startDate, Timestamp endDate);
}
