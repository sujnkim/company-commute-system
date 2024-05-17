package com.example.commutesystem.service;

import com.example.commutesystem.domain.employee.Employee;
import com.example.commutesystem.dto.employee.request.EmployeeCreateRequest;
import com.example.commutesystem.dto.employee.response.EmployeeResponse;
import com.example.commutesystem.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAllwithTeam().stream()
                .map(EmployeeResponse::new)
                .toList();
    }

}

