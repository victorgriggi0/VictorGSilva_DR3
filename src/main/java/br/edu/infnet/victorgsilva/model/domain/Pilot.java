package br.edu.infnet.victorgsilva.model.domain;

public class Pilot {
	
    private String name;
    private int age;
    private String license;
    private int flightHours;
    
    public Pilot(String name, int age, String license, int flightHours) {
    	this.setName(name);
    	this.setAge(age);
    	this.setLicense(license);
    	this.setFlightHours(flightHours);
    }
    
	@Override
	public String toString() {
		
		return "Piloto: " + name + ", Idade: " + age + ", Licença: " + license + ", Horas de Vôo: " + flightHours;
		
	}
    
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
	
}
