package com.digicert.hotelreservations.repository;

import com.digicert.hotelreservations.models.HotelSite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelSiteRepository extends CrudRepository<HotelSite, Long> {

}
