package com.example.commutesystem.domain;

import com.example.commutesystem.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "team_name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Employee> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

}

