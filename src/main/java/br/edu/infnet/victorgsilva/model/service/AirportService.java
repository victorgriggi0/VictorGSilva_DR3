package br.edu.infnet.victorgsilva.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.victorgsilva.model.domain.Airport;
import br.edu.infnet.victorgsilva.model.domain.Adress;

public class AirportService {
    
    private Map<String, Airport> airports = new HashMap<>();
    private AdressService adressService;

    public AirportService(AdressService adressService) {
        this.adressService = adressService;
    }

    public Collection<Airport> getAll() {
        return airports.values();
    }

    public Airport get(String code) {
        return airports.get(code);
    }

    public void create(Airport airport) {
        airports.put(airport.getCode(), airport);
        
        System.out.println("A adição do aeroporto " + airport.getName() + " foi realizada com sucesso.");
    }

    public void delete(String code) {
    	System.out.println("A exclusão do aeroporto " + code + " foi realizada com sucesso.");
    	
    	airports.remove(code);
    }

    public void edit(String code, String newName, String newZip) {
        if (airports.containsKey(code)) {
            Airport airport = airports.get(code);
            Adress newAdress = adressService.get(newZip);
            
            if (newAdress == null) {
                System.out.println("Endereço com CEP " + newZip + " não encontrado.");
                return;
            }
            
            airport.setName(newName);
            airport.setAdress(newAdress);

            System.out.println("O aeroporto " + code + " foi atualizado com sucesso: Nome: " + newName + ", CEP: " + newZip);
        } else {
            System.out.println("Aeroporto com código " + code + " não encontrado.");
        }
    }
    
}
