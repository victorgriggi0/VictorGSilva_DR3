package br.edu.infnet.victorgsilva.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.victorgsilva.model.domain.Pilot;

public class PilotService {
    
    private Map<String, Pilot> pilots = new HashMap<String, Pilot>();
    
    public Collection<Pilot> getAll() {
        return pilots.values();
    }
    
    public Pilot get(String name) {
        return pilots.get(name);
    }

    public void create(Pilot pilot) {    	
        System.out.println("A adição do piloto " + pilot + " foi realizada com sucesso.");
        
        pilots.put(pilot.getName(), pilot);
    }
    
    public void delete(String name) {
    	System.out.println("A exclusão do piloto " + name + " foi realizada com sucesso.");
    	
    	pilots.remove(name);
    }

    public void edit(String name, int newAge, String newLicense, int newFlightHours) {
        if (pilots.containsKey(name)) {
            Pilot pilot = pilots.get(name);
            pilot.setAge(newAge);
            pilot.setLicense(newLicense);
            pilot.setFlightHours(newFlightHours);
            System.out.println("A edição do piloto " + name + " foi realizada com sucesso.");
        } else {
            System.out.println("Piloto com nome " + name + " não encontrado.");
        }
    }
    
}
