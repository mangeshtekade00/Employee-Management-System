package com.backend_springboot.restapiCreater1.repository;

import com.backend_springboot.restapiCreater1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
