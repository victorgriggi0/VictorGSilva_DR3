package br.edu.infnet.victorgsilva.model.domain;

import java.util.List;

public class Airport {
	
	private String name;
	private String code;
	private Adress adress;
	
    public Airport(String name, String code, Adress adress) {
        this.name = name;
        this.code = code;
        this.adress = adress;
    }
	
	@Override
	public String toString() {
		
		return "Aeroporto: " + name + ", Código: " + code;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
	
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
	
}
