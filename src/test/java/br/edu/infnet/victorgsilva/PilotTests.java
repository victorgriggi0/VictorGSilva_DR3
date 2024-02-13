package br.edu.infnet.victorgsilva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Pilot;

class PilotTests {

	private Pilot pilot;
	
	@BeforeEach
	void setUp() {
		pilot = new Pilot();
		pilot.setName("Victor");
		pilot.setAge(22);
		pilot.setLicense("SPL");
	}
	
	@Test
	void pilotShouldBeJunior() {
        pilot.setFlightHours(1000);
        
        // Irá fazer a verificação para analisar se o status é "Júnior"
        assertFalse(pilot.isSeniorPilot());
        assertEquals("Júnior", pilot.getStatus());
	}
	
    @Test
    void pilotShouldBeSenior() {
        pilot.setFlightHours(2000);
        
        // Irá fazer a verificação para analisar se o status é "Sênior"
        assertTrue(pilot.isSeniorPilot());
        assertEquals("Sênior", pilot.getStatus());
    }
    
    @Test
    void recoverData() {
    	pilot.setFlightHours(1500);
    	
    	assertEquals("Victor", pilot.getName(), "O nome do piloto não corresponde.");
        assertEquals(22, pilot.getAge(), "A idade do piloto não corresponde.");
        assertEquals("SPL", pilot.getLicense(), "A licença do piloto não corresponde.");
        assertEquals(1500, pilot.getFlightHours(), "As horas de voo do piloto não correspondem.");
    }
    
}
