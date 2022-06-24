package com.cibergames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cibergames.model.VideoJuego;
import com.cibergames.repositorio.ICategoriaRepository;
import com.cibergames.repositorio.IEmpresaRepository;
import com.cibergames.repositorio.ITipoJuegoRepository;
import com.cibergames.repositorio.IVideoJuegoRepository;

@Controller
public class VideoJuegoController {
	
	@Autowired
	private IVideoJuegoRepository repoVideoJuego;
	@Autowired
	private ICategoriaRepository repoCategoria;
	@Autowired
	private IEmpresaRepository repoEmpresa;
	@Autowired
	private ITipoJuegoRepository repoTipoJuego;
	
	@GetMapping("/juegos/cargar")
	public String cargarListaJuegos(Model model) {
		
		//Objeto de tipo videojuego
		model.addAttribute("videojuego", new VideoJuego());
		
		//Lista de videojuegos
		model.addAttribute("listaVideoJuegos", repoVideoJuego.findAll());
		
		//Combo categoria
		model.addAttribute("listaCategoria", repoCategoria.findAll());
		
		// Combo empresa
		model.addAttribute("listaEmpresa", repoEmpresa.findAll());
		
		// Combo tipo juego
		model.addAttribute("listaTipoJuego", repoTipoJuego.findAll());

		return "Juegos";
	}
}
