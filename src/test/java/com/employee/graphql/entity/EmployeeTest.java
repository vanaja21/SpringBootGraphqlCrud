package com.employee.graphql.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String empName;
	private Integer Salary;
	private Integer empExp;
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}
	public Integer getEmpExp() {
		return empExp;
	}
	public void setEmpExp(Integer empExp) {
		this.empExp = empExp;
	}
	
		
}
