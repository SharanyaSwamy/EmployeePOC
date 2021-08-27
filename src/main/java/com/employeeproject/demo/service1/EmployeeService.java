package com.employeeproject.demo.service1;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.employeeproject.demo.entity.Employee;
import com.employeeproject.demo.exception.ResourceNotFoundException;

public interface EmployeeService {
	
	public List<Employee> retrieveEmployees();
	  
	 public Optional<Employee> getEmployee(Long employeeId) throws ResourceNotFoundException;
	  
	 public Employee saveEmployee(Employee employee);
	  
	 public Map<String,Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;

	 public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException;

}
