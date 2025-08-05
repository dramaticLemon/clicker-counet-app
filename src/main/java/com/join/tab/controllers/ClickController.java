package com.join.tab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.join.tab.service.ClickerService;

@Controller
public class ClickController {

	private final ClickerService clickerService;

	public ClickController(ClickerService clickerService) {
		this.clickerService = clickerService;
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showClickPage(Model model) {
		model.addAttribute("count", clickerService.getCount());
		return "index";
	}

	@RequestMapping(path="/click", method=RequestMethod.POST)
	public String handleClick(Model model) {
		int newCount = clickerService.incrementAndGet();
		model.addAttribute("count", newCount);
		return "index";
	}

}
