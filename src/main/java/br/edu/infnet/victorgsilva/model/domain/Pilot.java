package br.edu.infnet.victorgsilva.model.domain;

public class Pilot {
    private String name;
    private int age;
    private String license;
    private int flightHours;
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public int getFlightHours() {
		return flightHours;
	}
	
	public void setFlightHours(int flightHours) {
		this.flightHours = flightHours;
	}
	
	// Atribui o status de "Sênior" caso o piloto tenha mais de 1500 horas de vôo
    public boolean isSeniorPilot() {
        if (flightHours < 0) {
            throw new IllegalArgumentException("Oops! As horas de vôo não podem ser negativas...");
        }
        
        return flightHours > 1500;
    }
    
    // Verifica o status do piloto, tendo como base o retorno de "isSeniorPilot()"
    public String getStatus() {
        try {
            if (isSeniorPilot()) {
                return "Sênior";
            } else {
                return "Júnior";
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return "Status Indisponível";
        }
    }
}
