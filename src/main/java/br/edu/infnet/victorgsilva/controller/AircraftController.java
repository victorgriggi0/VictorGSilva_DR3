package br.edu.infnet.victorgsilva.controller;

import br.edu.infnet.victorgsilva.model.domain.Aircraft;
import br.edu.infnet.victorgsilva.model.domain.Pilot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    private final List<Aircraft> aircrafts = new ArrayList<>();

    @GetMapping
    public List<Aircraft> getAllAircrafts() {
        return aircrafts;
    }
    
    @GetMapping("/{id}/pilot")
    public Pilot getPilotByAircraftId(@PathVariable long id) {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getId() == id) {
                return aircraft.getPilot();
            }
        }
        
        return null;
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        aircrafts.add(aircraft);
        return aircraft;
    }

    @DeleteMapping("/{id}")
    public boolean deleteAircraft(@PathVariable long id) {
        return aircrafts.removeIf(aircraft -> aircraft.getId() == id);
    }
    
}
