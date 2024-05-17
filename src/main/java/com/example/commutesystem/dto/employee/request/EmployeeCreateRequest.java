package com.example.commutesystem.dto.employee.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeCreateRequest {

    private String name;
    private Boolean isManager;
    private LocalDate workStartDate;
    private LocalDate birthday;

}

