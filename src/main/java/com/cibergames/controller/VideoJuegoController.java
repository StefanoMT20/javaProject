package com.cibergames.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	//POST PARA REGISTRAR JUEGOS
	@PostMapping("/juegos/grabar")
	public String grabarJuegos(Model model, @ModelAttribute VideoJuego juego, 
			@RequestParam("file") MultipartFile imagen) {
		
		try {
			try {
			if(!imagen.isEmpty()) { //Si la imagen no es vacia
				//Ruta relativa
				Path directorioImagenes = Paths.get("src//main//resources//static/images/juegos");
				//Ruta absoluta
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				//Leer bytes de la imagen
				byte[] bytesImagen = imagen.getBytes();
				
				//Escribir los bytes en la ruta donde tenemos nuestros recursos img
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImagen);
				
				//Seteando el atributo imagen del objeto Videojuego
				juego.setRuta_img_juego(imagen.getOriginalFilename());
				
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			repoVideoJuego.save(juego);
			model.addAttribute("mensaje confirmacion", "Juego Registrado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mensaje fallido", "Algo ha ocurrido. No ha podido registrarse el juego");
		}
		
		
		//Lista de videojuegos
		model.addAttribute("listaVideoJuegos", repoVideoJuego.findAll());
		
		//Combo categoria
		model.addAttribute("listaCategoria", repoCategoria.findAll());
		
		// Combo empresa
		model.addAttribute("listaEmpresa", repoEmpresa.findAll());
		
		// Combo tipo juego
		model.addAttribute("listaTipoJuego", repoTipoJuego.findAll());

		return "redirect:/juegos/cargar";
	}

	@PostMapping("/juegos/editar") //El modelAttribute es para capturar un atrbiuto //El model es para enviar un atributo
	public String buscarEditarProductoPag(@ModelAttribute VideoJuego videojuego, Model model) {//Solo capturamos el id
		System.out.println(videojuego);
		
		//
		model.addAttribute("videojuego", repoVideoJuego.findById(videojuego.getCodigo_juego()));
		
		
		//Lista de videojuegos
		model.addAttribute("listaVideoJuegos", repoVideoJuego.findAll());
		
		//Combo categoria
		model.addAttribute("listaCategoria", repoCategoria.findAll());
		
		// Combo empresa
		model.addAttribute("listaEmpresa", repoEmpresa.findAll());
		
		// Combo tipo juego
		model.addAttribute("listaTipoJuego", repoTipoJuego.findAll());
				
		
		return "MantVideoJuegos";
	}
	
	@PostMapping("/juegos/eliminar")
	public String eliminarJuego(@ModelAttribute VideoJuego videojuego, Model model) {
		
		repoVideoJuego.deleteById(videojuego.getCodigo_juego());
		
		//Lista de videojuegos
		model.addAttribute("listaVideoJuegos", repoVideoJuego.findAll());
		
		//Combo categoria
		model.addAttribute("listaCategoria", repoCategoria.findAll());
		
		// Combo empresa
		model.addAttribute("listaEmpresa", repoEmpresa.findAll());
		
		// Combo tipo juego
		model.addAttribute("listaTipoJuego", repoTipoJuego.findAll());
		
		return "redirect:/juegos/cargar";
	}
}
