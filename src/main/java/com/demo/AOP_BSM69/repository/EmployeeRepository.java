package com.demo.AOP_BSM69.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.AOP_BSM69.model.Employee;
  
@Repository 
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
  
}
 
