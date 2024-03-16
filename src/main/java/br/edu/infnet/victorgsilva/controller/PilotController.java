package br.edu.infnet.victorgsilva.controller;

import br.edu.infnet.victorgsilva.model.domain.Pilot;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pilots")
public class PilotController {

    private final List<Pilot> pilots = new ArrayList<>();

    @GetMapping
    public List<Pilot> getAllPilots() {
        return pilots;
    }

    @PostMapping
    public Pilot createPilot(@RequestBody Pilot pilot) {
        pilots.add(pilot);
        return pilot;
    }

    @DeleteMapping("/{id}")
    public boolean deletePilot(@PathVariable long id) {
        return pilots.removeIf(pilot -> pilot.getId() == id);
    }
    
}
