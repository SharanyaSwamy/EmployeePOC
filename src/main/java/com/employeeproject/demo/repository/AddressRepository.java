package com.employeeproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeproject.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
