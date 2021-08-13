package com.agenor.crudemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.agenor.crudemployee"})
public class CrudEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEmployeeApplication.class, args);
	}

}
