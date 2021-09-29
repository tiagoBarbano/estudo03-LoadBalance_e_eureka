package com.api.cambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CambioApplication.class, args);

		System.out.println("Serviço em Funcionamento");
	}

}
