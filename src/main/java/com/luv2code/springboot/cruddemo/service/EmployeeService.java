package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Employee employee = null;
		Optional<Employee> result = this.employeeRepository.findById(id);
		if(result.isPresent()) employee = result.get();
		else throw new RuntimeException(String.format("Did not find an employee id - %s", id));
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
	}
	
	
	public Employee findByEmailAndLastName(String email, String lastName) {
		return this.employeeRepository.findByEmailAndLastName(email, lastName);
	}

}
