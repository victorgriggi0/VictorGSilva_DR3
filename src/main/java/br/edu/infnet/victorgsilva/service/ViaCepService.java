package br.edu.infnet.victorgsilva.service;

import br.edu.infnet.victorgsilva.model.domain.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Address getAddressByZip(String zip) {
        final String uri = "https://viacep.com.br/ws/" + zip + "/json/";
        Address address = restTemplate.getForObject(uri, Address.class);
        
        return address;
    }
    
}
