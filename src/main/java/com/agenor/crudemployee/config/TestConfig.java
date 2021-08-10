package com.agenor.crudemployee.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agenor.crudemployee.entities.Employee;
import com.agenor.crudemployee.repositories.EmployeeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Employee e1 = new Employee(null, "Pedro de Souza", "10/10/2000", "M", "Desenvolvedor", true, 3500);
		Employee e2 = new Employee(null, "João da Silva", "25/12/2000", "M", "Desenvolvedor", true, 3500);
		
		employeeRepository.saveAll(Arrays.asList(e1, e2));
	}
}
