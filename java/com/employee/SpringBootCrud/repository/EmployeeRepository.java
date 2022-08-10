package com.employee.SpringBootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.SpringBootCrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}