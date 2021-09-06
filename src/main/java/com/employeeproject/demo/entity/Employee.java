package com.employeeproject.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private Long id;
	  
	 @Column(name="EMPLOYEE_NAME")
	 private String name;
	  
	 @Column(name="EMPLOYEE_SALARY")
	 private Integer salary;
	  
	 @Column(name="DEPARTMENT")
	 private String department;
	 
	 /*
	 
	 @OneToMany(mappedBy = "Employee", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnore
	 private List<Address> address = new ArrayList<>();
	 

	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public List<Address> getAddress() {
		return address;
	}

*/
	public Employee() {
		}
		 
	 
	 public Employee(String name, Integer salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}


	public Long getId() {
	  return id;
	 }
	 
	 public void setId(Long id) {
	  this.id = id;
	 }
	 
	 public String getName() {
	  return name;
	 }
	 
	 public void setName(String name) {
	  this.name = name;
	 }
	 
	 public Integer getSalary() {
	  return salary;
	 }
	 
	 public void setSalary(Integer salary) {
	  this.salary = salary;
	 }
	 
	 public String getDepartment() {
	  return department;
	 }
	 
	 public void setDepartment(String department) {
	  this.department = department;
	 }


	
}
