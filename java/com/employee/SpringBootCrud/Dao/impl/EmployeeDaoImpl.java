package com.employee.SpringBootCrud.Dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.employee.SpringBootCrud.Dao.EmployeeDAO;
import com.employee.SpringBootCrud.model.Employee;

//@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    private static final Map<Long, Employee> empMap = new HashMap<Long, Employee>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee(1001L, "Smith", "Developer");
        Employee emp2 = new Employee(1002L, "Allen", "HR");
        Employee emp3 = new Employee(1003L, "Jones", "Manager");
        Employee emp4 = new Employee(1004L, "Josh", "Architect");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
    }

    public Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }

}
