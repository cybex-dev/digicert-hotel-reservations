package com.digicert.hotelreservations.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hotel_sites")
public class HotelSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    /// Ideally this would be a string representing a location on a map, alternatively a country, city and address breakdown, etc.
    @Column(name = "location", nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private HotelType type;

    public HotelSite() {

    }

    public HotelSite(Long id, String name, String location, String description, HotelType type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, description, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HotelSite other = (HotelSite) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(location, other.location)
                && Objects.equals(description, other.description) && Objects.equals(type, other.type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }
}
