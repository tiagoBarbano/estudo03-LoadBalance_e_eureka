package com.api.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookApplication {

	private static Logger logger = LoggerFactory.getLogger(String.class);

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);

		logger.info("Serviço Iniciado");
	}

}
