package br.edu.infnet.victorgsilva.controller;

import br.edu.infnet.victorgsilva.model.domain.Airport;
import br.edu.infnet.victorgsilva.model.domain.Address;
import br.edu.infnet.victorgsilva.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final List<Airport> airports = new ArrayList<>();

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airports;
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        String cep = airport.getAddress().getCep();
        Address address = viaCepService.getAddressByZip(cep);
        if (address != null) {
            airport.setAddress(address);
            airports.add(airport);
        } else {
            throw new RuntimeException("Erro: Endereço não encontrado para o CEP fornecido.");
        }
        
        return airport;
    }

    @DeleteMapping("/{id}")
    public boolean deleteAirport(@PathVariable long id) {
        return airports.removeIf(airport -> airport.getId() == id);
    }
    
}
