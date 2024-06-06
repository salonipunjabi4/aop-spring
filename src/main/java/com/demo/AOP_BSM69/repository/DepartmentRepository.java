package com.demo.AOP_BSM69.repository;

import org.springframework.stereotype.Repository;

import com.demo.AOP_BSM69.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer > {

}
