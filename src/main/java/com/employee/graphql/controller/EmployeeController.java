package com.employee.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.employee.graphql.entity.Employee;
import com.employee.graphql.entity.EmployeeData;
import com.employee.graphql.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@QueryMapping
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@QueryMapping
	public Employee getEmployeeById(@Argument Integer id) {
	 
		return empService.getEmployeeById(id);
    
	} 
	
	@MutationMapping
	public Employee addEmployee(@Argument String empName, @Argument Integer empExp, @Argument Integer salary) {
		Employee emp = new Employee();
		emp.setEmpExp(empExp);
		emp.setEmpName(empName);
		emp.setSalary(salary);
	    return empService.addEmployee(emp);
		
	}
	
	@MutationMapping
	public Employee deleteEmployee(@Argument Integer id) {
		return empService.deleteEmployeeById(id);
	}
	
	@MutationMapping
	public Employee updateEmployee(@Argument EmployeeData empData) {
		Employee emp = new Employee(empData.getEmpId(),empData.getEmpName(),empData.getEmpExp(),empData.getSalary());
		return empService.updateEmployeeById(emp);
	}
	
}

