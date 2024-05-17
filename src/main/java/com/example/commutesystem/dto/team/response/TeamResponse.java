package com.example.commutesystem.dto.team.response;

import com.example.commutesystem.domain.Team;
import com.example.commutesystem.domain.employee.Role;
import lombok.Getter;

@Getter
public class TeamResponse {

    private String name;
    private String manager;
    private Integer memberCount;

    public TeamResponse(Team team) {
        this.name = team.getName();
        this.manager = getManagerName(team);
        this.memberCount = team.getMembers().size();
    }

    private String getManagerName(Team team) {
        return team.getMembers().stream()
                .filter(member -> member.getRole() == Role.MANAGER)
                .map(member -> member.getName())
                .findFirst()
                .orElse(null);
    }

}

