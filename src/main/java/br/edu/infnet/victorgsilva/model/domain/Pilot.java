package br.edu.infnet.victorgsilva.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Pilot {
    
    private long id;
    private String name;
    private String license;
    private int flightHours;
    private List<Aircraft> aircrafts;

    public Pilot(long id, String name, String license, int flightHours) {
        this.id = id;
        this.name = name;
        this.license = license;
        this.flightHours = flightHours;
        this.aircrafts = new ArrayList<>();
    }
    
    public void addAircraft(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLicense() { return license; }
    public void setLicense(String license) { this.license = license; }

    public int getFlightHours() { return flightHours; }
    public void setFlightHours(int flightHours) { this.flightHours = flightHours; }
    
}
