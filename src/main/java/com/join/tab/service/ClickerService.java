package com.join.tab.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class ClickerService {

	private final AtomicInteger countValue = new AtomicInteger();

	public int incrementAndGet() {
		return countValue.incrementAndGet();
	}

	public int getCount() {
		return this.countValue.get();
	}
}
