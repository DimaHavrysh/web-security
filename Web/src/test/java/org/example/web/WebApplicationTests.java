package org.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebApplicationTests {
    @Autowired MockMvc mockMvc;
    String json = "{\"title\":\"test\",\"author\":\"test\"}";

    @Test @WithMockUser(roles = "USER") void userPost403() throws Exception {
        mockMvc.perform(post("/api/items").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isForbidden());
    }

    @Test @WithMockUser(roles = "USER") void userPut403() throws Exception {
        mockMvc.perform(put("/api/items/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isForbidden());
    }

    @Test @WithMockUser(roles = "USER") void userDelete403() throws Exception {
        mockMvc.perform(delete("/api/items/1")).andExpect(status().isForbidden());
    }

    @Test @WithMockUser(roles = "ADMIN") void adminPost200() throws Exception {
        mockMvc.perform(post("/api/items").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().is2xxSuccessful());
    }

    @Test @WithMockUser(roles = "ADMIN") void adminPut200() throws Exception {
        mockMvc.perform(put("/api/items/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test @WithMockUser(roles = "ADMIN") void adminDelete200() throws Exception {
        mockMvc.perform(delete("/api/items/1")).andExpect(status().isOk());
    }

    @Test @WithMockUser(roles = "USER") void userGet200() throws Exception {
        mockMvc.perform(get("/api/items")).andExpect(status().isOk());
    }

    @Test @WithAnonymousUser void anonymous401() throws Exception {
        mockMvc.perform(get("/api/items")).andExpect(status().isUnauthorized());
    }

    @Test @WithMockUser(roles = "USER") void userGetOne200() throws Exception {
        mockMvc.perform(get("/api/items/1")).andExpect(status().isOk());
    }

    @Test @WithMockUser(roles = "ADMIN") void adminGetOne200() throws Exception {
        mockMvc.perform(get("/api/items/1")).andExpect(status().isOk());
    }

}
