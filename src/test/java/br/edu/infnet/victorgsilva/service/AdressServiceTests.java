package br.edu.infnet.victorgsilva.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.infnet.victorgsilva.model.domain.Adress;
import br.edu.infnet.victorgsilva.model.service.AdressService;

class AdressServiceTests {

    private AdressService service;

    @BeforeEach
    public void setUp() {
        service = new AdressService();
    }
    
    @Test
    public void testGetAllAdresses() {
    	int initialSize = service.getAll().size();
    			
        Adress a1 = new Adress("68908119");
        service.create(a1);

        Adress a2 = new Adress("33333");
        service.create(a2);

        Collection<Adress> adresses = service.getAll();
        assertNotNull(adresses, "A coleção de endereços não deve ser nula");
        assertEquals(initialSize + 2, adresses.size(), "Deve haver exatamente dois endereços adicionados à coleção");
    }

    @Test
    public void testCreateAndGetAdress() {
        Adress adress = new Adress("68908119");
        adress.setCity("Macapá");
        service.create(adress);

        Adress retrievedAdress = service.get("68908119");
        assertNotNull(retrievedAdress, "O endereço deve ser encontrado");
        assertEquals("Macapá", retrievedAdress.getCity(), "A cidade do endereço deve ser 'Macapá'");
    }

    @Test
    public void testDeleteAdress() {
        Adress adress = new Adress("68908119");
        service.create(adress);

        assertNotNull(service.get("68908119"), "O endereço deve existir antes da exclusão");
        service.delete("68908119");
        assertNull(service.get("68908119"), "O endereço deve ser nulo após a exclusão");
    }
    
    @Test
    public void testDeleteNonExistingAdress() {
        final String nonExistingZip = "CEP Fantasma";
        Adress initialAdress = service.get(nonExistingZip);
        assertNull(initialAdress, "O endereço inicialmente não deve existir");

        service.delete(nonExistingZip);
        Adress adressAfterDeletionAttempt = service.get(nonExistingZip);
        assertNull(adressAfterDeletionAttempt, "O endereço ainda deve ser inexistente após a tentativa de exclusão");
    }

    
    @Test
    public void testEditAdress() {
        Adress adress = new Adress("68908119");
        adress.setCity("Belém");
        service.create(adress);

        service.edit("68908119", "Rua Hildemar Maia", "Jesus de Nazaré", "Macapá", "AP");
        Adress editedAdress = service.get("68908119");

        assertEquals("Macapá", editedAdress.getCity(), "A cidade do endereço deve ser atualizada para 'Macapá'");
        assertEquals("AP", editedAdress.getState(), "O estado do endereço deve ser atualizado para 'AP'");
    }

    @Test
    public void testEditNonExistingAdress() {
        final String nonExistingZip = "CEP Fantasma";
        Adress adress = service.get(nonExistingZip);
        assertNull(adress, "O endereço inicialmente não deve existir");

        service.edit(nonExistingZip, "Avenida Fantasma", "Bairro Fantasma", "Cidade Fantasma", "Estado Fantasma");
        Adress adressAfterEditAttempt = service.get(nonExistingZip);
        assertNull(adressAfterEditAttempt, "O endereço ainda deve ser inexistente após a tentativa de edição");
    }

}
