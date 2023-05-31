package com.app.EmployeeApp.repository;

import com.app.EmployeeApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
