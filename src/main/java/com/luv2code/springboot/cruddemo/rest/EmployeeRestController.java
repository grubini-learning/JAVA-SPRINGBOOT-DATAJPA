package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private IEmployeeService employeeService;

	@Autowired
	public EmployeeRestController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
//	@GetMapping(path = "/employees", produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> minions = this.employeeService.findAll();
		return minions;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = this.employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException(String.format("Employee id not found - %s", employeeId));
		}
		return employee;
	}
	
	@GetMapping("")
	
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		this.employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		this.employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee auxEmployee = this.employeeService.findById(employeeId);
		if (auxEmployee == null) throw new RuntimeException(String.format("Employee id not found - %s", employeeId));
		else {
			this.employeeService.deleteById(employeeId);
			return String.format("Deleted employee id - %d", employeeId);
		}
	}
}
