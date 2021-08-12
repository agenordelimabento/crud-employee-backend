package com.agenor.crudemployee.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.agenor.crudemployee.entities.Employee;
import com.agenor.crudemployee.repositories.EmployeeRepository;
import com.agenor.crudemployee.services.exceptions.DatabaseException;
import com.agenor.crudemployee.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee findById(Long id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Employee insert(Employee obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Employee update(Long id, Employee obj) {
		try {
		Employee entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Employee entity, Employee obj) {
		entity.setNome(obj.getNome());
		entity.setDataNasc(obj.getDataNasc());
		entity.setCargo(obj.getCargo());
		entity.setSalario(obj.getSalario());
		entity.setAtivo(obj.isAtivo());
		entity.setSexo(obj.getSexo());
						
	}
}
