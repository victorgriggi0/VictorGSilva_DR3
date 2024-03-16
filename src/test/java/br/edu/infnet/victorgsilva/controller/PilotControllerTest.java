package br.edu.infnet.victorgsilva.controller;

import br.edu.infnet.victorgsilva.model.domain.Pilot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PilotController.class)
public class PilotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPilots() throws Exception {
        mockMvc.perform(get("/pilots"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreatePilot() throws Exception {
        Pilot newPilot = new Pilot(1, "Victor Griggi Silva", "PC-A", 1500);

        mockMvc.perform(post("/pilots")
	    .contentType(MediaType.APPLICATION_JSON)
	    .content(new ObjectMapper().writeValueAsString(newPilot)))
	    .andExpect(status().isOk());
    }
    
}
