package com.employeeproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeproject.demo.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
