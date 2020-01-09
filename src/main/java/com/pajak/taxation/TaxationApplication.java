package com.pajak.taxation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = TaxRateConversation.class)
public class TaxationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxationApplication.class, args);
	}

}
