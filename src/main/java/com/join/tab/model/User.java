package com.join.tab.model;

import java.util.UUID;

public class User {
	private final UUID uuid;
	private String name;
	private String email;
	
	public User() {
		this.uuid = UUID.randomUUID();
	}

	public User(String name, String email) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.email = email;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", name=" + name + ", email=" + email + "]";
	}

	
	
}
