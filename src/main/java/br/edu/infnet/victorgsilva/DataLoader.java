	package br.edu.infnet.victorgsilva;
	
	import br.edu.infnet.victorgsilva.controller.AircraftController;
	import br.edu.infnet.victorgsilva.controller.AirportController;
	import br.edu.infnet.victorgsilva.controller.PilotController;
	import br.edu.infnet.victorgsilva.model.domain.Address;
	import br.edu.infnet.victorgsilva.model.domain.Aircraft;
	import br.edu.infnet.victorgsilva.model.domain.Airport;
	import br.edu.infnet.victorgsilva.model.domain.Pilot;
	import br.edu.infnet.victorgsilva.service.ViaCepService;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Component;
	
	@Component
	public class DataLoader implements CommandLineRunner {
	
	    @Autowired
	    private AirportController airportController;
	    @Autowired
	    private PilotController pilotController;
	    @Autowired
	    private AircraftController aircraftController;
	    @Autowired
	    private ViaCepService viaCepService;
	
	    @Override
	    public void run(String... args) throws Exception {
	        loadAirports();
	        loadPilots();
	        loadAircrafts();
	    }
	
	    private void loadAirports() {
	    	airportController.createAirport(new Airport(1, "Aeroporto Internacional de Macapá - Alberto Alcolumbre", "MCP", new Address("68902-200", null, null, null, null, null)));
	    	airportController.createAirport(new Airport(2, "Aeroporto Internacional de Cuiabá - Marechal Rondon", "CGB", new Address("78005-100", null, null, null, null, null)));
	
	        System.out.println("🚀 Sucesso: Os aeroportos foram adicionados!");
	    }
	
	    private void loadPilots() {
	        pilotController.createPilot(new Pilot(1, "Victor Griggi Silva", "PC-A", 1500));
	        pilotController.createPilot(new Pilot(2, "Jefferson Regis da Silva", "PLA-A", 1200));
	        pilotController.createPilot(new Pilot(3, "Iliana Griggi Silva", "PLA-H", 1200));
	
	        System.out.println("🚀 Sucesso: Os pilotos foram adicionados!");
	    }
    
	    private void loadAircrafts() {
	        List<Pilot> pilots = pilotController.getAllPilots();
	        
	        if (!pilots.isEmpty()) {
	            aircraftController.createAircraft(new Aircraft(1, "Boeing 737", "B1", pilots.get(0)));
	            aircraftController.createAircraft(new Aircraft(2, "Airbus A320", "A1", pilots.get(1)));
	            aircraftController.createAircraft(new Aircraft(3, "Embraer 190", "E1", pilots.get(2)));
	        }

	        System.out.println("🚀 Sucesso: As aeronaves foram adicionadas!");
	    }
    
}
