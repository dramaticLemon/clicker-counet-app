package com.join.tab.repository;

import org.springframework.stereotype.Repository;

import com.join.tab.model.Clicker;

@Repository
public class ClickerRepository {
	
	public Clicker fetchClicker() {
		return new Clicker();
	}

	public void saveClicker(Clicker clicker) {
		// save logic
	}

}
