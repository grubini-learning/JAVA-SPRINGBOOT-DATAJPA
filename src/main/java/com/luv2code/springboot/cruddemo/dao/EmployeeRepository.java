package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmailAndLastName(String email, String lastname);
	List<Employee> findByEmailLikeAndLastNameLike(String email, String lastName);
}
