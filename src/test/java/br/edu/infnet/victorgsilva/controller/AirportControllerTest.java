package br.edu.infnet.victorgsilva.controller;

import br.edu.infnet.victorgsilva.model.domain.Address;
import br.edu.infnet.victorgsilva.model.domain.Airport;
import br.edu.infnet.victorgsilva.service.ViaCepService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirportController.class)
public class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ViaCepService viaCepService;

    @Test
    public void testGetAllAirports() throws Exception {
        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateAirport() throws Exception {
    	Address address = new Address("07190-100", "Rodovia Hélio Smidt", "Complemento", "Aeroporto", "Guarulhos", "SP");
        Airport newAirport = new Airport(1, "Aeroporto Internacional de Guarulhos", "GRU", address);

        given(viaCepService.getAddressByZip("07190-100")).willReturn(address);

        mockMvc.perform(post("/airports")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newAirport)))
                .andExpect(status().isOk());
    }
    
}
