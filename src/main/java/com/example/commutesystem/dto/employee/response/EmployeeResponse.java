package com.example.commutesystem.dto.employee.response;

import com.example.commutesystem.domain.employee.Employee;
import com.example.commutesystem.domain.employee.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeResponse {

    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public EmployeeResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = employee.getTeam().getName();
        this.role = employee.getRole();
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }

}

