package br.edu.infnet.victorgsilva.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.edu.infnet.victorgsilva.model.domain.Airport;
import br.edu.infnet.victorgsilva.model.service.AdressService;
import br.edu.infnet.victorgsilva.model.service.AirportService;
import br.edu.infnet.victorgsilva.model.domain.Adress;

public class AirportServiceTests {

    private AirportService airportService;

    @Mock
    private AdressService adressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        airportService = new AirportService(adressService);

        Adress adress = new Adress("78110900");
        adress.setCity("Cuiabá");
        when(adressService.get("78110900")).thenReturn(adress);
        when(adressService.get("00000000")).thenReturn(null);
    }

    @Test
    public void testGetAllAirports() {
        int initialSize = airportService.getAll().size();
        
        airportService.create(new Airport("Aeroporto 1", "001", new Adress("99999999")));
        airportService.create(new Airport("Aeroporto 2", "002", new Adress("78110900")));

        Collection<Airport> airports = airportService.getAll();
        assertEquals(initialSize + 2, airports.size(), "Deve haver exatamente dois aeroportos adicionados à coleção");
    }

    @Test
    public void testCreateAndGetAirport() {
        Airport airport = new Airport("Aeroporto Internacional de Cuiabá - Marechal Rondon", "CGB", new Adress("78110900"));
        airportService.create(airport);

        Airport retrievedAirport = airportService.get("CGB");
        assertNotNull(retrievedAirport, "O aeroporto deve ser encontrado");
    }

    @Test
    public void testDeleteAirport() {
        airportService.create(new Airport("Aeroporto Internacional de Cuiabá - Marechal Rondon", "CGB", new Adress("78110900")));
        assertNotNull(airportService.get("CGB"), "O aeroporto deve existir antes da exclusão");

        airportService.delete("CGB");
        assertNull(airportService.get("CGB"), "O aeroporto deve ser nulo após a exclusão");
    }

    @Test
    public void testEditExistingAirportWithExistingZip() {
        Airport initialAirport = new Airport("Construção do Aeroporto", "NEW", new Adress("78110900"));
        airportService.create(initialAirport);

        airportService.edit("NEW", "Aeroporto Finalizado", "78110900");
        Airport updatedAirport = airportService.get("NEW");

        assertNotNull(updatedAirport, "O aeroporto editado deve existir");
        assertEquals("Aeroporto Finalizado", updatedAirport.getName(), "O nome do aeroporto deve ser atualizado");
        assertEquals("Cuiabá", updatedAirport.getAdress().getCity(), "A cidade do endereço deve ser Cuiabá");
    }

    @Test
    public void testEditExistingAirportWithNonExistingZip() {
        Airport initialAirport = new Airport("Construção do Aeroporto", "NEW", new Adress("78110900"));
        airportService.create(initialAirport);

        airportService.edit("NEW", "Aeroporto Suspendido", "00000000");
        Airport updatedAirport = airportService.get("NEW");

        assertNotNull(updatedAirport, "O aeroporto deve ainda existir após tentativa de edição com CEP inexistente");
        assertEquals("78110900", updatedAirport.getAdress().getZip(), "O CEP do aeroporto não deve ser alterado para um CEP inexistente");
    }
    
    @Test
    public void testEditNonExistingAirport() {
        Airport initialAirport = new Airport("Aeroporto Internacional de Cuiabá - Marechal Rondon", "MCP", new Adress("78110900"));
        airportService.create(initialAirport);
        
        airportService.edit("FTSM", "Nome Fantasma", "00000000");
    }
    
}
