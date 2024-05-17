package com.example.commutesystem.service;

import com.example.commutesystem.domain.employee.Employee;
import com.example.commutesystem.dto.employee.request.EmployeeCreateRequest;
import com.example.commutesystem.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public void saveEmployee(EmployeeCreateRequest request) {
        employeeRepository.save(new Employee(
                request.getName(),
                request.getIsManager(),
                request.getWorkStartDate(),
                request.getBirthday()
        ));
    }

}

