package br.edu.infnet.victorgsilva.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.victorgsilva.model.domain.Adress;

public class AdressService {
    
    private Map<String, Adress> adresses = new HashMap<String, Adress>();

    public Collection<Adress> getAll() {
        return adresses.values();
    }

    public Adress get(String zip) {
        return adresses.get(zip);
    }

    public void create(Adress adress) {
        System.out.println("A adição do endereço " + adress + " foi realizada com sucesso.");

        adresses.put(adress.getZip(), adress);
    }

    public void delete(String zip) {
        if (adresses.containsKey(zip)) {
            System.out.println("A exclusão do endereço com CEP " + zip + " foi realizada com sucesso.");
            adresses.remove(zip);
        } else {
            System.out.println("Endereço com CEP " + zip + " não encontrado.");
        }
    }

    public void edit(String zip, String newAvenue, String newNeighborhood, String newCity, String newState) {
        if (adresses.containsKey(zip)) {
            Adress adress = adresses.get(zip);
            adress.setAvenue(newAvenue);
            adress.setNeighborhood(newNeighborhood);
            adress.setCity(newCity);
            adress.setState(newState);
            System.out.println("A edição do endereço com CEP " + zip + " foi realizada com sucesso.");
        } else {
            System.out.println("Endereço com CEP " + zip + " não encontrado.");
        }
    }
}
