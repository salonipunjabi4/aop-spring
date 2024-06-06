package com.demo.AOP_BSM69.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.AOP_BSM69.model.Employee;
import com.demo.AOP_BSM69.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);	}
	
	public Employee findById(Integer id) {
		return employeeRepository.findById(id).orElseThrow();
				
	}

}
