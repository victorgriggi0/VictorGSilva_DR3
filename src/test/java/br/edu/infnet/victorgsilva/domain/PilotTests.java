package br.edu.infnet.victorgsilva.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Pilot;

class PilotTests {

	private Pilot pilot;
	
	@BeforeEach
	void setUp() {
    	pilot = new Pilot("Victor", 22, "SPL", 4750);
	}
	
    @Test
    void toStringTest() {
        String expected = "Piloto: Victor, Idade: 22, Licença: SPL, Horas de Vôo: 4750";
        assertEquals(expected, pilot.toString(), "A representação em String do aeroporto não corresponde ao esperado.");
    }
    
    @Test
    void recoverData() {
    	assertEquals("Victor", pilot.getName(), "O nome do piloto não corresponde.");
        assertEquals(22, pilot.getAge(), "A idade do piloto não corresponde.");
        assertEquals("SPL", pilot.getLicense(), "A licença do piloto não corresponde.");
        assertEquals(4750, pilot.getFlightHours(), "As horas de voo do piloto não correspondem.");
    }
    
}
