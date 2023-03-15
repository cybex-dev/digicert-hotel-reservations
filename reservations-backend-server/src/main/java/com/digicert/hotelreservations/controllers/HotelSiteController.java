package com.digicert.hotelreservations.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("sites")
//@Path("/sites")
public class HotelSiteController {

//    @GET
//    # @Path("/hello")
//    @Produces({ MediaType.APPLICATION_JSON})
//    public @ResponseBody String greeting() {
//        return "Hello, World";
//    }

//    @RequestMapping("/greeting")
//    public @ResponseBody String greeting() {
//        return "Hello, World";
//    }

//    @RequestMapping("/")
    @GetMapping(path = "/hello", produces = "application/json")
//    @Produces({ MediaType.APPLICATION_JSON})
    public @ResponseBody String hello() {
        return "Hello";
    }

//     TODO migrate away from DI, see https://www.springcloud.io/post/2022-08/spring-field-injection/#gsc.tab=0
//    @Autowired
//    private HotelSiteRepository hotelSiteRepository;

//    @GetMapping("/all")
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public List<HotelSite> getAllHotelSites() {
//        return (List<HotelSite>) hotelSiteRepository.findAll();
//    }
}
