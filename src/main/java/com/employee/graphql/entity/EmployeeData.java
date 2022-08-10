package com.employee.graphql.entity;

import lombok.Data;

@Data
public class EmployeeData {
	private Integer empId;
	private String empName;
	private Integer Salary;
	private Integer empExp;
	
	
	public EmployeeData(Integer empId, String empName, Integer salary, Integer empExp) {
		super();
		this.empId = empId;
		this.empName = empName;
		Salary = salary;
		this.empExp = empExp;
	}
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
