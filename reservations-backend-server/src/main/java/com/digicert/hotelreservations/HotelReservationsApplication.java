package com.digicert.hotelreservations;

import com.digicert.hotelreservations.models.Reservation;
import com.digicert.hotelreservations.repository.HotelReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class HotelReservationsApplication implements CommandLineRunner {

    private HotelReservationsRepository hotelReservationsRepository;

    @Autowired
    public HotelReservationsApplication(HotelReservationsRepository hotelReservationsRepository) {
        this.hotelReservationsRepository = hotelReservationsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Reservation reservation = new Reservation();
            reservation.setId(random.nextLong());
            Date checkInDate = new Date();
            Date checkOutDate = addDays(checkInDate, i % 10);
            Timestamp checkin = new Timestamp(checkInDate.getTime());
            Timestamp checkOut = new Timestamp(checkOutDate.getTime());

            reservation.setCheckIn(checkin);
            reservation.setCheckOut(checkOut);
            reservation.setGuestName("Guest " + i);
            reservation.setRoomNumber(i);

            hotelReservationsRepository.save(reservation);
        }
    }

    private Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
