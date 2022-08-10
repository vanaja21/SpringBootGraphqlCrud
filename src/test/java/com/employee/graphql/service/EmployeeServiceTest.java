package com.employee.graphql.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.graphql.entity.Employee;
import com.employee.graphql.repo.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	void testGetAllEmployees() {
		when(employeeRepository.findAll())
		.thenReturn(Stream.of(new Employee(1001,"vanaja", 40000,2),
				              new Employee(1002,"Joshvik",450000, 3),
				              new Employee(1002,"kirthika",50000, 4))
				.collect(Collectors.toList()));
		assertEquals(3,employeeService.getAllEmployees().size());
	}
	
	@Test
	void testAddEmployee() {
		when(employeeRepository.save(new Employee(1001,"vanaja", 40000,2)))
		.thenReturn(new Employee(1001,"vanaja", 40000,2));
		assertEquals(new Employee(1001,"vanaja", 40000,2),
				employeeService.addEmployee(new Employee(1001,"vanaja", 40000,2)));
	}
	
	@Test
	void testGetEmployeeById_Positive() {
		when(employeeRepository.findById(1001))
		.thenReturn(Optional.of(new Employee(1001,"vanaja", 40000,2)));
		assertEquals(new Employee(1001,"vanaja", 40000,2),employeeService.getEmployeeById(1001));
	}
	
	@Test
	void testGetEmployeeById_Negative() {
		when(employeeRepository.findById(1100)).thenReturn(java.util.Optional.empty());
		assertEquals(null,employeeService.getEmployeeById(1200));
	}
	
	@Test
	void testUpdateEmployeeById_positive() {
		when(employeeRepository.findById(1001))
		.thenReturn(Optional.of(new Employee(1001,"vanaja", 40000,2)));
		when(employeeRepository.save(new Employee(1001,"vanajaG", 40000,2)))
		.thenReturn(new Employee(1001,"vanajaG", 40000,2));
		assertEquals(new Employee(1001,"vanajaG", 40000,2),
				employeeService.updateEmployeeById(new Employee(1001,"vanajaG", 40000,2)));
	}
	
	@Test
	void testUpdateEmployeeById_negative() {
		when(employeeRepository.findById(1100)).thenReturn(Optional.empty());
		assertEquals(null,employeeService.updateEmployeeById(new Employee(1100,"test",35000,4)));
	}
	
	@Test
	void testDeleteEmployee_positive() {
		when(employeeRepository.findById(1001)).thenReturn(Optional.of(new Employee(1001,"vanaja", 40000,2)));
		assertEquals(new Employee(1001,"vanaja", 40000,2),employeeService.deleteEmployeeById(1001));
		
	}
	
	@Test
	void testDeleteEmployeeq_negative() {
		when(employeeRepository.findById(1100)).thenReturn(java.util.Optional.empty());
		assertEquals(null,employeeService.deleteEmployeeById(1100));
		
	}
	}

