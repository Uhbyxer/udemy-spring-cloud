package com.acme.first;

import com.acme.first.domain.Player;
import com.acme.first.domain.Team;
import com.acme.first.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FirstApplication {
	@Autowired
	private TeamRepository teamRepository;

	@PostConstruct
	public void init() {
		List<Team> teams = new ArrayList<>();
		Team team = new Team();
		team.setLocation("Harlem");
		team.setName("Shake");
		teams.add(team);

		Set<Player> players = new HashSet<>();
		players.add(new Player("Big Easy", "Showman"));
		players.add(new Player("Buckets", "Guard"));
		players.add(new Player("Dizzy", "Guard"));
		team.setPlayers(players);
		teamRepository.save(team);

		team = new Team();
		team.setLocation("Lviv");
		team.setName("Karpaty");
		teams.add(team);
		teamRepository.save(team);
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
}
