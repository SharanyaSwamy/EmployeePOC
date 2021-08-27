package com.employeeproject.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeproject.demo.entity.Employee;
import com.employeeproject.demo.repository.EmployeeRepository;
import com.employeeproject.demo.service1.EmployeeService;
import com.employeeproject.demo.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	/* public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		  this.employeeRepository = employeeRepository;
	}*/

	@Override
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		  return employees;
	}

	@Override
	public Optional<Employee> getEmployee(Long employeeId) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("emp not found for id :: " +employeeId));
		employeeRepository.deleteById(employeeId);
		
		employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
		
	}

	@Override
	public Employee updateEmployee(Long  employeeId, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("emp not found for id :: " +employeeId));
		
		employee.setName(employeeDetails.getName());
		employee.setSalary(employeeDetails.getSalary());
		employee.setDepartment(employeeDetails.getDepartment());
		
		final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
	}

}
