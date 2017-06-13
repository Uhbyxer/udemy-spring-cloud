package com.acme.first.controller;

import com.acme.first.domain.Team;
import com.acme.first.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}

	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable("id") long id) {
		return teamRepository.findOne(id);
	}
}
