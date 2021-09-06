package com.employeeproject.demo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.employeeproject.demo.controller.EmployeeRestController;
import com.employeeproject.demo.dto.EmployeeDTO;
import com.employeeproject.demo.entity.Employee;
import com.employeeproject.demo.exception.ResourceNotFoundException;
import com.employeeproject.demo.service1.EmployeeService;
import com.employeeproject.demo.repository.EmployeeRepository;

public class TestEmployeeController extends SpringBootCurdH2ApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@InjectMocks
	EmployeeRestController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@Mock
    EmployeeRepository employeeRepository;
	
	EmployeeDTO employeeDTO;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
		employeeDTO = new EmployeeDTO();
		
		employeeDTO.setId(1);
		employeeDTO.setName("Gaurav");
		employeeDTO.setSalary(3000);
		employeeDTO.setDepartment("IT");
		
	}

	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/employees")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.name").value("Gaurav"))
				.andExpect(jsonPath("$.salary").value(3000)).andExpect(jsonPath("$.department").value("IT"));

	}
	
	@Test
	public void testgetEmployees() throws ResourceNotFoundException {
		List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setName("john");
        empOne.setDepartment("IT");
        empOne.setSalary(3000);
         
        list.add(empOne);
		
	    when(employeeService.retrieveEmployees()).thenReturn(list);
	    List<Employee> empList = employeeService.retrieveEmployees();
	    
	    assertEquals(1, empList.size());
	    verify(employeeService).retrieveEmployees();
	}
	
	@Test
	public void testPostEmployees() {
		Employee emp = new Employee();
		emp.setName("John");
		when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(emp);
		Employee created= employeeService.saveEmployee(emp);
		assertThat(created.getName()).isSameAs(emp.getName());
		verify(employeeRepository).save(emp);
	}
	
	@Test
	public void testDeleteEmployee() throws ResourceNotFoundException {
		Employee emp = new Employee();
		emp.setName("John");
		emp.setId(1L);
		when(employeeRepository.findById(emp.getId())).thenReturn(Optional.of(emp));
		employeeService.deleteEmployee(emp.getId());
		verify(employeeRepository).deleteById(emp.getId());
	}
	
	@Test(expected = RuntimeException.class)
	public void testThrowExceptionWhenEmpDosentExist() throws ResourceNotFoundException {
		Employee emp = new Employee();
		emp.setName("John");
		emp.setId(1L);
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
		employeeService.deleteEmployee(emp.getId());	
	}

}
