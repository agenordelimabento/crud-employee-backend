package com.agenor.crudemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenor.crudemployee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
