package com.digicert.hotelreservations.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "guest_name", length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String guestName;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "check_in_date", nullable = false)
    private Date checkIn;

    @Column(name = "check_out_date", nullable = false)
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(String guestName, Integer roomNumber, Date checkIn, Date checkOut) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestName, roomNumber, checkIn, checkOut);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Reservation other = (Reservation) obj;
        return Objects.equals(id, other.id) && Objects.equals(guestName, other.guestName)
                && Objects.equals(roomNumber, other.roomNumber) && Objects.equals(checkIn, other.checkIn)
                && Objects.equals(checkOut, other.checkOut);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
