package com.cibergames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibergames.repositorio.IBoletaRepository;
import com.cibergames.repositorio.IUsuarioRepository;

@Controller
public class BoletaController {
	
	@Autowired
	IBoletaRepository repoBole;
	@Autowired
	IUsuarioRepository repoUsu;
	
	
	@GetMapping("/boleta/listado")
	public String listadoBoletas(Model model) {
		
		model.addAttribute("listadoUsuarios", repoUsu.findAll());
		
		return "ListadoBoleta";
	}
	
	@PostMapping("/boleta/filtro")
	public String listadoBoletaFiltro(Model model, @RequestParam (name="usuario")int usuario) {
		
		model.addAttribute("listadoBoletaFiltro", repoBole.findByCodigoUsuario(usuario));
		
		model.addAttribute("listadoUsuarios", repoUsu.findAll());
		
		return "ListadoBoleta";
	}
}
