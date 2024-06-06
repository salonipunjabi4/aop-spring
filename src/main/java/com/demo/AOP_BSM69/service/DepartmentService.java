package com.demo.AOP_BSM69.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.AOP_BSM69.annotation.CustomAnnotation;
import com.demo.AOP_BSM69.model.Department;
import com.demo.AOP_BSM69.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}
	
	@CustomAnnotation
	public Department findById(Integer id) {
		return departmentRepository.findById(id).orElseThrow();
	}

}
