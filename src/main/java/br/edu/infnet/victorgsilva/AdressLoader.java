package br.edu.infnet.victorgsilva;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.victorgsilva.model.domain.Adress;
import br.edu.infnet.victorgsilva.model.service.AdressService;

@Component
public class AdressLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		AdressService adressService = new AdressService();

        Adress a1 = new Adress("68908119");
        a1.setAvenue("Rua Hildemar Maia");
        a1.setNeighborhood("Jesus de Nazaré");
        a1.setCity("Macapá");
        a1.setState("PA");
        adressService.create(a1);

        Adress a2 = new Adress("78110900");
        a2.setAvenue("Avenida Governador João Ponce de Arruda");
        a2.setNeighborhood("Centro-Norte");
        a2.setCity("Várzea Grande");
        a2.setState("MT");
        adressService.create(a2);
        
        Adress a3 = new Adress("66115900");
        a3.setAvenue("Avenida Pará");
        a3.setNeighborhood("Val-de-Cães");
        a3.setCity("Belém");
        a3.setState("PA");
        adressService.create(a3);

        System.out.println("Todos os endereços no sistema:\n");
        adressService.getAll().forEach(System.out::println);

        adressService.edit("68908119", "Rua Hildemar Maia", "Jesus de Nazaré", "Macapá", "AP");
        System.out.println("Endereço atualizado:\n");
        System.out.println(adressService.get("68908119"));

        adressService.delete("66115900");
        System.out.println("Atualização dos endereços cadastrados no sistema:\n");
        adressService.getAll().forEach(System.out::println);
        
	}
	
}
