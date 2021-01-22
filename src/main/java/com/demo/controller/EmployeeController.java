package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employees;
import com.demo.repository.EmployeeRepository;
import com.demo.response.ApiResponse;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/getAllEmployee")
	public ApiResponse getAllEmployee() {		
		List<Employees> ee=  employeeRepository.findAll();
		
		if(ee == null) {
			System.out.println("No record Found");
		}		
		return new ApiResponse(Boolean.TRUE, "Success", HttpStatus.PRECONDITION_FAILED.value(),ee);
	}
	
	@GetMapping("/getEmployeeById")
	public ApiResponse getEmployeeNyId(@RequestParam("eid") int eid) {		
		Optional<Employees> y = employeeRepository.findById(eid);		
		if(y == null) {
			System.out.println("No record Found");
		}		
		return new ApiResponse(Boolean.TRUE, "Success", HttpStatus.PRECONDITION_FAILED.value(),y);
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee() {
		Employees ee = new Employees();
		ee.setName("ravindra");
		ee.setAddress("Indore");
		employeeRepository.save(ee);
		System.out.println(ee.toString());
		
		return "Success";
	}
	
	
}
