package com.example.commutesystem.repository.employee;

import com.example.commutesystem.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

