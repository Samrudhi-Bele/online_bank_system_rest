package com.example.E_Banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("Com")
public class EBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

}
