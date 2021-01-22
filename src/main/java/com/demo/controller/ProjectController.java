package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Employees;
import com.demo.model.Projects;
import com.demo.repository.ProjectRepository;
import com.demo.response.ApiResponse;

public class ProjectController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@GetMapping("/getAllProject")
	public ApiResponse getAllProjects() {		
		List<Projects> ee=  projectRepo.findAll();
		
		if(ee == null) {
			System.out.println("No Project Found");
		}		
		return new ApiResponse(Boolean.TRUE, "Success", HttpStatus.PRECONDITION_FAILED.value(),ee);
	}
	
	@GetMapping("/getProjectById")
	public ApiResponse getProjectsById(@RequestParam("pid") int pid) {		
		Optional<Projects> p = projectRepo.findById(pid);	
		if(p == null) {
			System.out.println("No Detail Found");
		}		
		return new ApiResponse(Boolean.TRUE, "Success", HttpStatus.PRECONDITION_FAILED.value(),p);
	}
	
	
}
