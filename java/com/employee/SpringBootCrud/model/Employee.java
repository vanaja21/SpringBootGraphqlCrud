package com.employee.SpringBootCrud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "empNo of the Employee",name="name",required=true,value="test empNo")
	private Long empNo;
    
    
	@ApiModelProperty(notes = "empName of the Employee",name="name",required=true,value="test empName")
	@Column(name = "empName")
    private String empName;
	
	@ApiModelProperty(notes = "position of the Employee",name="name",required=true,value="test position")
	@Column(name = "position")
    private String position;

    public Employee() {

    }

    public Employee(Long empNo, String empName, String position) {
        this.empNo = empNo;
        this.empName = empName;
        this.position = position;
    }

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
    
}
