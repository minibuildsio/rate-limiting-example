package io.minibuilds.ratelimiting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class StuffControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void login_endpoint_is_restricted_to_3_requests_in_a_short_time() throws Exception {
    for (int i = 0; i < 3; i++) {
      mockMvc.perform(post("/login")).andExpect(status().isOk());
    }

    mockMvc.perform(post("/login")).andExpect(status().isTooManyRequests());
  }

  @Test
  void stuff_endpoint_is_restricted_to_20_requests_in_a_short_time() throws Exception {
    for (int i = 0; i < 20; i++) {
      mockMvc.perform(get("/stuff")).andExpect(status().isOk());
    }

    mockMvc.perform(get("/stuff")).andExpect(status().isTooManyRequests());
  }
}