package com.digicert.hotelreservations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HotelReservationsControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;
//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/reservations", String.class)).isEqualTo("Hello");
//    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.mockMvc).isNotNull();
        this.mockMvc.perform(get("/api/v1/reservations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

}
