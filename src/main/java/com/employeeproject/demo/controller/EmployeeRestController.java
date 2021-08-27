package com.employeeproject.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;

import com.employeeproject.demo.entity.Employee;
import com.employeeproject.demo.service1.EmployeeService;
import com.employeeproject.demo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	 private EmployeeService employeeService;
	  
	/* public void setEmployeeService(EmployeeService employeeService) {
	  this.employeeService = employeeService;
	 }*/
	 
	 @GetMapping("/employees")
	 public List<Employee> getEmployees() {
	  return employeeService.retrieveEmployees();
	 }
	  
	 @GetMapping("/employees/{employeeId}")
	 public ResponseEntity < Employee > getEmployee(@PathVariable(value="employeeId")Long employeeId) throws ResourceNotFoundException {
	     Employee employee = employeeService.getEmployee(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employye not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(employee);
	 }
	  
	 @PostMapping("/employees")
	 public Employee saveEmployee(@Valid @RequestBody Employee employee){
	// public Employee saveEmployee(Employee employee){
		// employeeService.saveEmployee(new Employee(employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartment()))
	  return employeeService.saveEmployee(employee);
	  //System.out.println("Employee Saved Successfully");
	 }
	  
	 @DeleteMapping("/employees/{employeeId}")
	 public Map < String, Boolean > deleteEmployee(@PathVariable(value="employeeId")Long employeeId) throws ResourceNotFoundException{
	  return employeeService.deleteEmployee(employeeId);
	  //System.out.println("Employee Deleted Successfully");
	 }
	  
	 @PutMapping("/employees/{employeeId}")
	 public ResponseEntity <Employee> updateEmployee(@PathVariable(value ="employeeId") Long employeeId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
	  Employee emp = employeeService.updateEmployee(employeeId,employeeDetails);
	  return ResponseEntity.ok(emp);
	   
	 }

}
