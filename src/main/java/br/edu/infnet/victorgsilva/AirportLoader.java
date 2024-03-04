package br.edu.infnet.victorgsilva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.victorgsilva.model.domain.Adress;
import br.edu.infnet.victorgsilva.model.domain.Airport;
import br.edu.infnet.victorgsilva.model.service.AdressService;
import br.edu.infnet.victorgsilva.model.service.AirportService;

@Component
public class AirportLoader implements ApplicationRunner {

    @Autowired
    private AdressService adressService;

    @Autowired
    private AirportService airportService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
        Adress adress = adressService.get("68908119");
        Airport airport = new Airport("Aeroporto Internacional de Macapá", "MCP", adress);
        airportService.create(airport);

        System.out.println("Aeroporto criado:\n");
        System.out.println(airportService.get("MCP"));

        airportService.edit("Aeroporto Internacional de Macapá - Alberto Alcolumbre", "MCP", "68908119");

        System.out.println("Atualização dos aeroportos cadastrados no sistema:\n");
        System.out.println(airportService.get("MCP"));
    }

}
