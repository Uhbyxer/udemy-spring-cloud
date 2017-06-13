package com.acme.first.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String position;

	public Player() {
	}

	public Player(String name, String position) {

		this.name = name;
		this.position = position;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Player player = (Player) o;

		if (id != null ? !id.equals(player.id) : player.id != null)
			return false;
		if (name != null ? !name.equals(player.name) : player.name != null)
			return false;

		return position != null ? position.equals(player.position) : player.position == null;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (position != null ? position.hashCode() : 0);
		return result;
	}

	@Override public String toString() {
		return "Player{" + "id=" + id + ", name='" + name + '\'' + ", position='" + position + '\'' + '}';
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
