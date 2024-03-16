package br.edu.infnet.victorgsilva.model.domain;

public class Airport {
	
	private long id;
    private String name;
    private String code;
    private Address address;

    public Airport() {}

    public Airport(long id, String name, String code, Address address) {
    	this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    
}
