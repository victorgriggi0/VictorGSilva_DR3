package br.edu.infnet.victorgsilva.model.domain;

public class Adress {

	private String zip;
	private String avenue;
	private String neighborhood;
	private String city;
	private String state;
	
	public Adress(String zip) {
		this();
		this.zip = zip;
	}

	public Adress() {

	}
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAvenue() {
		return avenue;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
