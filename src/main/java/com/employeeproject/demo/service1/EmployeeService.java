package com.employeeproject.demo.service1;

import java.util.List;

import com.employeeproject.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> retrieveEmployees();
	  
	 public Employee getEmployee(Long employeeId);
	  
	 public void saveEmployee(Employee employee);
	  
	 public void deleteEmployee(Long employeeId);
	  
	 public void updateEmployee(Employee employee);

}
