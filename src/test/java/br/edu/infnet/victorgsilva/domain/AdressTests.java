package br.edu.infnet.victorgsilva.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Adress;

class AdressTest {
	
	private Adress adress;

    @BeforeEach
    public void setUp() {
        adress = new Adress();
        adress.setZip("68908119");
        adress.setAvenue("Rua Hildemar Maia");
        adress.setNeighborhood("Jesus de Nazaré");
        adress.setCity("Macapá");
        adress.setState("AP");
    }
    
    @Test
    void recoverData() {
    	assertEquals("68908119", adress.getZip(), "O CEP deve ser recuperado corretamente");
        assertEquals("Rua Hildemar Maia", adress.getAvenue(), "A avenida deve ser recuperada corretamente");
        assertEquals("Jesus de Nazaré", adress.getNeighborhood(), "O bairro deve ser recuperado corretamente");
        assertEquals("Macapá", adress.getCity(), "A cidade deve ser recuperada corretamente");
        assertEquals("AP", adress.getState(), "O estado deve ser recuperado corretamente");
    }

}
