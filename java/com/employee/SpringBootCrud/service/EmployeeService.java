package com.employee.SpringBootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.SpringBootCrud.model.Employee;
import com.employee.SpringBootCrud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	public Employee getEmployee(Long empNo) {
		return empRepository.findById(empNo).orElse(null);
	}

	public Employee updateEmployee(Employee emp) {
		Optional<Employee> optEmp = empRepository.findById(emp.getEmpNo());
		if(optEmp.isPresent()) {
			return empRepository.save(emp);
		}
		else {
			return null;
		}
	}

	public Employee deleteEmployee(Long empNo) {
		Optional<Employee> emp = empRepository.findById(empNo);
		if(emp.isPresent()) {
			empRepository.deleteById(empNo);
			return emp.get();
		}
		else {
			return null;
		}		
	

	}

	public Employee addEmployee(Employee emp) {
		return empRepository.save(emp);
	}

}
