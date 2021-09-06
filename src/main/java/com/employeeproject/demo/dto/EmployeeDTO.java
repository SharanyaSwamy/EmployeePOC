package com.employeeproject.demo.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	
	public EmployeeDTO() {

	}
	public EmployeeDTO(long id, String name, long salary, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	private long id;
	private String name;
	private long salary;
	private String department;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
