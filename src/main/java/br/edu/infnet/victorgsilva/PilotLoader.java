package br.edu.infnet.victorgsilva;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.victorgsilva.model.domain.Pilot;
import br.edu.infnet.victorgsilva.model.service.PilotService;

@Component
public class PilotLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
        PilotService pilotService = new PilotService();
		
    	pilotService.create(new Pilot("Victor", 22, "SPL", 4750));
    	pilotService.create(new Pilot("Jefferson", 54, "SPL", 5000));

        System.out.println("\nPilotos Criados:\n");
        pilotService.getAll().forEach(System.out::println);
        
        System.out.println("\nEditando o piloto Jefferson...\n");
        pilotService.edit("Jefferson Regis da Silva", 54, "SPL", 7000);
        
        System.out.println("Lista de pilotos atualizada:\n");
        pilotService.getAll().forEach(System.out::println);
        
        System.out.println("\nDetalhes do piloto Victor:");
        System.out.println(pilotService.get("Victor"));
        
        System.out.println("\nDeletando o piloto Victor...\n");
        pilotService.delete("Victor");
        
        System.out.println("Lista de pilotos atualizada:\n");
        pilotService.getAll().forEach(System.out::println);
        
	}
	
}
