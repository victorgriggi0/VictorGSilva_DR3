package br.edu.infnet.victorgsilva.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Aircraft {
    
    private long id;
    private String model;
    private String registrationNumber;

    @JsonIgnore
    private Pilot pilot;

    public Aircraft(long id, String model, String registrationNumber, Pilot pilot) {
        this.id = id;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.pilot = pilot;
        pilot.addAircraft(this);
    }
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public Pilot getPilot() { return pilot; }
    public void setPilot(Pilot pilot) {
        if (this.pilot != null) {
            this.pilot.getAircrafts().remove(this);
        }
        this.pilot = pilot;
        pilot.addAircraft(this);
    }
    
}
