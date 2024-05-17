package com.example.commutesystem.controller;

import com.example.commutesystem.dto.employee.request.EmployeeCreateRequest;
import com.example.commutesystem.dto.employee.response.EmployeeResponse;
import com.example.commutesystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/employee")
    public void saveEmployee(@RequestBody EmployeeCreateRequest request) {
        employeeService.saveEmployee(request);
    }


    @GetMapping("/employees")
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }

}

