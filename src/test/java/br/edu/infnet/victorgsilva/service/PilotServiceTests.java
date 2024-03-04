package br.edu.infnet.victorgsilva.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Pilot;
import br.edu.infnet.victorgsilva.model.service.PilotService;

class PilotServiceTests {

    private PilotService service;

    @BeforeEach
    void setUp() {
        service = new PilotService();
    }
    
    @Test
    void testGetAllPilots() {
    	service.create(new Pilot("Jefferson", 54, "SPL", 7000));
        service.create(new Pilot("Iliana", 52, "SPL", 1200));

        Collection<Pilot> pilots = service.getAll();
        assertEquals(2, pilots.size(), "O número de pilotos recuperados está incorreto.");
    }

    @Test
    void testCreateAndGetPilot() {
    	Pilot pilot = new Pilot("Victor", 22, "SPL", 4750);
    	service.create(pilot);
    	
        Pilot retrieved = service.get("Victor");
        assertNotNull(retrieved, "O piloto deveria ter sido criado e recuperado com sucesso.");
        assertEquals("SPL", retrieved.getLicense(), "A licença do piloto recuperado está incorreta.");
    }
    
    @Test
    void testDeletePilot() {
        Pilot pilot = new Pilot("Iliana", 52, "SPL", 1200);
        service.create(pilot);

        service.delete("Iliana");
        Pilot deleted = service.get("Iliana");
        assertNull(deleted, "O piloto deveria ter sido deletado.");
    }

    @Test
    void testEditPilot() {
    	Pilot pilot = new Pilot("Jefferson Regis da Silva", 42, "SPL", 5000);
    	service.create(pilot);

        service.edit("Jefferson Regis da Silva", 54, "SPL", 7000);
        Pilot edited = service.get("Jefferson Regis da Silva");
        assertEquals(54, edited.getAge(), "A edição da idade do piloto não foi bem-sucedida.");
        assertEquals(7000, edited.getFlightHours(), "A edição das horas de voo do piloto não foi bem-sucedida.");
    }
    
    @Test
    void testEditNonExistentPilot() {
        int initialSize = service.getAll().size();
        String nonExistentPilotName = "Piloto Fantasma";
        
        service.edit(nonExistentPilotName, 2, "XX", 22);
        
        int finalSize = service.getAll().size();
        Pilot nonExistentPilot = service.get(nonExistentPilotName);
        
        assertEquals(initialSize, finalSize, "O número de pilotos não deve mudar ao tentar editar um inexistente.");
        assertNull(nonExistentPilot, "O piloto inexistente realmente não deve existir após a tentativa de edição.");
    }
    
}
