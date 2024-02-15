package br.edu.infnet.victorgsilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.victorgsilva.model.domain.Pilot;

@SpringBootApplication
public class VictorgsilvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictorgsilvaApplication.class, args);
		
		Pilot p1 = new Pilot();
		p1.setName("Victor");
		p1.setAge(22);
		p1.setLicense("SPL");
		p1.setFlightHours(1500);
		
		
		Pilot p2 = new Pilot();
		p2.setName("Jefferson");
		p2.setAge(54);
		p2.setLicense("SPL");
		p2.setFlightHours(5000);
		
		Pilot p3 = new Pilot();
		p3.setName("Iliana");
		p3.setAge(52);
		p3.setLicense("SPL");
		p3.setFlightHours(1501);
		
		Pilot p4 = new Pilot();
		p4.setName("Samira");
		p4.setAge(20);
		p4.setLicense("SPL");
		p4.setFlightHours(1499);
		
		Pilot p5 = new Pilot();
		p5.setName("Roger");
		p5.setAge(20);
		p5.setLicense("SPL");
		p5.setFlightHours(-10);
		
		System.out.println("Nome do Piloto: " + p1.getName() + ", Idade: " + p1.getAge() + ", Licença: " + p1.getLicense() + ", Horas de Vôo: " + p1.getFlightHours() + ", Status: " + p1.getStatus());
		System.out.println("Nome do Piloto: " + p2.getName() + ", Status: " + p2.getStatus());
		System.out.println("Nome do Piloto: " + p3.getName() + ", Status: " + p3.getStatus());
		System.out.println("Nome do Piloto: " + p4.getName() + ", Status: " + p4.getStatus());
		System.out.println("Nome do Piloto: " + p5.getName() + ", Status: " + p5.getStatus());
	}

}