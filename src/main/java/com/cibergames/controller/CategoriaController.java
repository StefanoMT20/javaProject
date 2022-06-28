package com.cibergames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.cibergames.repositorio.ICategoriaRepository;
import com.cibergames.repositorio.IVideoJuegoRepository;

@Controller
public class CategoriaController {
	
	@Autowired
	ICategoriaRepository repoCate;
	@Autowired
	IVideoJuegoRepository repoJuego;
	
	
	@GetMapping("/categoria/listado")
	public String listadoBoletas(Model model) {
		
		model.addAttribute("listadoCategorias", repoCate.findAll());
		
		return "ListadoCategorias";
	}
	
	@PostMapping("/categoria/filtro")
	public String listadoBoletaFiltro(Model model, @RequestParam (name="categoria")int categoria) {

		model.addAttribute("listadoVideoJuegoFiltro", repoJuego.findByCodigoCategoria(categoria));
		
		model.addAttribute("listadoCategorias", repoCate.findAll());
		
		return "ListadoCategorias";
	}
}
