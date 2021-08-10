package com.agenor.crudemployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenor.crudemployee.entities.Employee;
import com.agenor.crudemployee.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.get();
	}
}
