package com.example.calendarproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SinglePageController {

	@GetMapping("{path:^(?!.*static).*$}/**")
	public String all() {
		return "index";
	}
}