package com.employeeproject.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PINCODE")
	private Long pincode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "employee_id"), name = "employee_id")
	private Employee employee;
	
	public Address(String street, String city, String state, Long pincode, Employee employe) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.employee = employee;
	}
	

}

