package com.example.commutesystem.controller;

import com.example.commutesystem.dto.team.request.TeamCreateRequest;
import com.example.commutesystem.dto.team.response.TeamResponse;
import com.example.commutesystem.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class TeamController {

    private final TeamService teamService;


    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamCreateRequest request) {
        teamService.saveTeam(request);
    }


    @GetMapping("/teams")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

}

