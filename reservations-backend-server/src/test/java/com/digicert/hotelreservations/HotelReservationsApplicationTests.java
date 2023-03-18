package com.digicert.hotelreservations;

import com.digicert.hotelreservations.controllers.HotelReservationsController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:application-integration-test.properties")
class HotelReservationsApplicationTests {

    @Autowired
    private HotelReservationsController hotelReservationsController;

    @Test
    void contextLoads() {
        assertThat(hotelReservationsController).isNotNull();
    }

}
