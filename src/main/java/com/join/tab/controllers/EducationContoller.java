package com.join.tab.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.join.tab.model.User;


@Controller
@RequestMapping("/app")
public class EducationContoller {
	
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveUser(@RequestBody User user, Model model) {
		model.addAttribute("savedUser", user);
		return "success";
	}

	@RequestMapping(path="/save/{name}/{email}", method=RequestMethod.POST)
	public String saveUserPathVariable(
		@PathVariable("name") String name,
		@PathVariable("email") String email,
		Model model) {
		User user = new User(name, email);
		model.addAttribute("savedUser", user);
		return "success";
	}

	@ModelAttribute("categories")
	public List<String> populateCategories() {
		List<String> categories = Arrays.asList("Electornics", "Books", "Food");
		return categories;
	}

	@GetMapping("/products")
	public String showProducts() {
		return "products";
	}

	@GetMapping("/a")
	public String a() {
		return "form";
	}

	@PostMapping("/saveUser")
	public String saveUserModel(@ModelAttribute User user, Model model) {
		System.out.println("------------");
		System.out.println(user.getName());
		System.out.println("------------");
		model.addAttribute("savedUser", user);
        return "success";
    }
}
