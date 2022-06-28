package com.cibergames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home/cargar")
	public String cargarHome() {
		return "Home";
	}
	
}
