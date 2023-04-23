package com.example.CardGameServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;

// @EntityScan("com.example.CardGameServer.entity")
@SpringBootApplication
public class CardGameServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGameServerApplication.class, args);
	}

}
