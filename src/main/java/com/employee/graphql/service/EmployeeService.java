package com.employee.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.graphql.entity.Employee;
import com.employee.graphql.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return empRepo.findById(id).orElse(null);
	}
	
	public Employee updateEmployeeById(Employee emp) {
		Optional<Employee> optEmp = empRepo.findById(emp.getEmpId());
		if(optEmp.isPresent()) {
			return empRepo.save(emp);
		}
		else {
			return null;
		}
	}
	
	public Employee deleteEmployeeById(Integer id) {
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isPresent()) {
			empRepo.deleteById(id);
			return emp.get();
		}
		else {
			return null;
		}		
	}

}

