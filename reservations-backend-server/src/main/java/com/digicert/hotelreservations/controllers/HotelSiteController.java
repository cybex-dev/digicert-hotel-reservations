package com.digicert.hotelreservations.controllers;

import com.digicert.hotelreservations.models.HotelSite;
import com.digicert.hotelreservations.repository.HotelSiteRepository;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HotelSiteController {

    // TODO migrate away from DI, see https://www.springcloud.io/post/2022-08/spring-field-injection/#gsc.tab=0
    @Autowired
    private HotelSiteRepository hotelSiteRepository;

    @GetMapping("/all")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<HotelSite> getAllHotelSites() {
        return (List<HotelSite>) hotelSiteRepository.findAll();
    }
}
