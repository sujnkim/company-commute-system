package com.example.commutesystem.domain.employee;

import com.example.commutesystem.domain.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_name", length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private LocalDate workStartDate;
    private LocalDate birthday;

    public Employee(
            String name,
            boolean isManager,
            LocalDate workStartDate,
            LocalDate birthday
    ) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    String.format("잘못된 name(%s)이 들어왔습니다.", name)
            );
        }
        this.name = name;

        if (isManager) {
            this.role = Role.MANAGER;
        } else {
            this.role = Role.MEMBER;
        }

        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }


    /**
     * 연관관계 편의 메서드
     */
    public void updateTeam(Team team) {
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }

        this.team = team;
        team.getMembers().add(this);
    }

}

