package com.join.tab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.join.tab.model.User;


@Controller
@RequestMapping("/app")
public class EdutaionContoller {
	
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveVehicle(@RequestBody User user, Model model) {
		model.addAttribute("savedUser", user);
		return "success";
	}
}
