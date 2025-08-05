package com.join.tab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.join.tab.service.ClickerService;

@Controller
public class ClickController {

	private final ClickerService clickerService;

	public ClickController(ClickerService clickerService) {
		this.clickerService = clickerService;
	}

	@GetMapping("/")
	public String showClickPage(Model model) {
		model.addAttribute("count", clickerService.getCount());
		return "index";
	}

	@PostMapping("/click")
	public String handleClick(Model model) {
		int newCount = clickerService.incrementAndGet();
		model.addAttribute("count", newCount);
		return "index";
	}

}
