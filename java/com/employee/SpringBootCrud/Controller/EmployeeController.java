package com.employee.SpringBootCrud.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.SpringBootCrud.model.Employee;
import com.employee.SpringBootCrud.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "EmployeeController", description = "REST Apis related to Student Entity!!!!")
@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	
	@Autowired
	EmployeeService empService;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
    @ApiOperation(value = "Get list of Employees in the System ", response = Iterable.class, tags = "getEmployees")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Suceess|OK"),
        @ApiResponse(code = 401, message = "not authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
     @RequestMapping(value = "/getAllEmployees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getAllEmployees() {
        List<Employee> list = empService.getAllEmployees();
        return list;
    }
    @ApiOperation(value = "Get specific employee in the System ", response = Employee.class, tags = "getEmployee")
    @RequestMapping(value = "/getEmpById/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmpById(@PathVariable("empNo") Long empNo) {
        return empService.getEmployee(empNo);
    }


    @RequestMapping(value = "/addEmployee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {

        System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());

        return empService.addEmployee(emp);
    }


    @RequestMapping(value = "/updateEmployee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {

        System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());

        return empService.updateEmployee(emp);
    }


    @RequestMapping(value = "/deleteEmployee/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee deleteEmployee(@PathVariable("empNo") Long empNo) {

        System.out.println("(Service Side) Deleting employee: " + empNo);

        Employee isEmpDeleted = empService.deleteEmployee(empNo);
		return isEmpDeleted;
    }

}
