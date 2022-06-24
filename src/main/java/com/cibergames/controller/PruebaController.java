package com.cibergames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {
	
	@GetMapping("prueba/cargar")
	public String cargarlogin () {
		return "Login";
	}
}
