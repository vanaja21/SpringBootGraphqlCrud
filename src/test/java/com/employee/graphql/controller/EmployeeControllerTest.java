package com.employee.graphql.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.employee.graphql.entity.Employee;
import com.employee.graphql.entity.EmployeeData;
import com.employee.graphql.repo.EmployeeRepository;
import com.employee.graphql.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService empService;
	 
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private EmployeeController employeeController;

	@MockBean
	private EmployeeRepository employeeRepository;

	
	@Test
	public void testgetAllEmployees() {
		when(employeeRepository.findAll())
		.thenReturn(Stream.of(new Employee(1001, "Joshvik",60000,2),
				new Employee(1002, "Adya",50000,2),new Employee(1003, "Vishnu",55000,4)
				).collect(Collectors.toList()));
		assertEquals(3, employeeController.getAllEmployees().size());

	}

	@Test
	public void testGetEmployeeById() {
		when(employeeRepository.findById(1001))
		.thenReturn(Optional.of(new Employee(1001, "Joshvik",60000,2)));
		assertEquals(new Employee(1001, "Joshvik",60000,2),employeeController.getEmployeeById(1001));
	}

	        
	@Test
	public void testAddEmployee() {
		when(employeeRepository.save(new Employee(1004, "Prasanna",60000,2)))
		.thenReturn(new Employee(1004, "Prasanna",60000,2));
		assertEquals(new Employee(1004, "Prasanna",60000,2),
				employeeController.addEmployee("Prasanna", 60000,2));
	}

	@Test
	public void testDeleteEmployeeById() {
		when(employeeRepository.findById(1001)).
		thenReturn(Optional.of(new Employee(1001, "Joshvik",60000,2)));
		assertEquals(new Employee(1001, "Joshvik",60000,2),employeeController.deleteEmployee(1001));
	}

	@Test
	public void testUpdateEmployee() {
		when(employeeRepository.findById(1002)).
		thenReturn(Optional.of(new Employee(1002, "Adya",50000,2)));
		when(employeeRepository.save(new Employee(1002, "Adya",50000,2)))
		.thenReturn(new Employee(1002, "Adya",50000,2));
		//assertEquals(new Employee(1002, "Adya",50000,2),
			//	employeeController.updateEmployee(new EmployeeData(1002, "Adya",50000,2)));
	}


}

