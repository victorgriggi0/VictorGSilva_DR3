package br.edu.infnet.victorgsilva.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Adress;
import br.edu.infnet.victorgsilva.model.domain.Airport;

public class AirportTests {

    private Airport airport;
    private Adress adress;

    @BeforeEach
    public void setUp() {
        adress = new Adress("78110900");
        adress.setAvenue("Avenida Governador João Ponce de Arruda");
        adress.setNeighborhood("Centro-Norte");
        adress.setCity("Várzea Grande");
        adress.setState("MT");
        airport = new Airport("Aeroporto Internacional de Cuiabá - Marechal Rondon", "CGB", adress);
    }

    @Test
    public void testGetName() {
        assertEquals("Aeroporto Internacional de Cuiabá - Marechal Rondon", airport.getName(), "O nome do aeroporto deve ser 'Aeroporto Internacional de Cuiabá - Marechal Rondon'");
    }

    @Test
    public void testSetName() {
        airport.setName("Aeroporto Internacional de Macapá - Alberto Alcolumbre");
        assertEquals("Aeroporto Internacional de Macapá - Alberto Alcolumbre", airport.getName(), "O nome do aeroporto deve ser atualizado para 'Aeroporto Internacional de Macapá - Alberto Alcolumbre'");
    }

    @Test
    public void testGetCode() {
        assertEquals("CGB", airport.getCode(), "O código do aeroporto deve ser 'CGB'");
    }

    @Test
    public void testSetCode() {
        airport.setCode("MCP");
        assertEquals("MCP", airport.getCode(), "O código do aeroporto deve ser atualizado para 'MCP'");
    }

    @Test
    public void testGetAdress() {
        assertEquals(adress, airport.getAdress(), "O endereço do aeroporto deve ser o mesmo que foi definido no setUp");
    }

    @Test
    public void testSetAdress() {
        Adress newAdress = new Adress("68908119");
        newAdress.setAvenue("Rua Hildemar Maia");
        newAdress.setNeighborhood("Jesus de Nazaré");
        newAdress.setCity("Macapá");
        newAdress.setState("AP");
        airport.setAdress(newAdress);
        assertEquals(newAdress, airport.getAdress(), "O endereço do aeroporto deve ser atualizado para o novo endereço");
    }

    @Test
    public void testToString() {
        String expected = "Aeroporto: Aeroporto Internacional de Cuiabá - Marechal Rondon, Código: CGB";
        assertEquals(expected, airport.toString(), "O método toString deve retornar a string correta");
    }

}
