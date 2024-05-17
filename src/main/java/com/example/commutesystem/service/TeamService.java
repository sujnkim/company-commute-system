package com.example.commutesystem.service;

import com.example.commutesystem.domain.Team;
import com.example.commutesystem.dto.team.request.TeamCreateRequest;
import com.example.commutesystem.dto.team.response.TeamResponse;
import com.example.commutesystem.repository.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;


    public void saveTeam(TeamCreateRequest request) {
        teamRepository.save(new Team(request.getName()));
    }


    public List<TeamResponse> getTeams() {
        return teamRepository.findAll().stream()
                .map(TeamResponse::new)
                .toList();
    }


}
