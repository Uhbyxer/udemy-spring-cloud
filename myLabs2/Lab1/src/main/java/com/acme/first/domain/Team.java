package com.acme.first.domain;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Team {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String location;
	private String mascotte;
	@OneToMany(cascade = ALL)
	@JoinColumn(name = "teamId")
	private Set<Player> players;

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Team team = (Team) o;

		if (id != null ? !id.equals(team.id) : team.id != null)
			return false;
		if (name != null ? !name.equals(team.name) : team.name != null)
			return false;
		if (location != null ? !location.equals(team.location) : team.location != null)
			return false;
		return mascotte != null ? mascotte.equals(team.mascotte) : team.mascotte == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (mascotte != null ? mascotte.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Team{" + "id=" + id + ", name='" + name + '\'' + ", location='" + location + '\'' + ", mascotte='"
				+ mascotte + '\'' + '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMascotte() {
		return mascotte;
	}

	public void setMascotte(String mascotte) {
		this.mascotte = mascotte;
	}
}
