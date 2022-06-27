package com.cibergames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibergames.model.Usuario;
import com.cibergames.repositorio.IUsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository repoUsuario;

	
	/**************INICIO LOGIN****************/
	
	@GetMapping("/")
	public String cargarLogin(Model model) {
		
		//Mandamos atributo de tipo usuario
		model.addAttribute("usuario", new Usuario());
		
		return "Login";
	}
	
	@PostMapping("/login/validar")
	public String validarLogin(Model model, @ModelAttribute Usuario usuario){
		
		Usuario usu = repoUsuario.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		
		if(usu==null) {
			return "Login";
		}
		else {
			return "Home";
		}
		
	}
	
	/*****************FIN LOGIN*******************/
	
	/**************INICIO REGISTRAR***************/
	
	@GetMapping("/regUsuario/cargar")
	public String cargarRegistrarUsuario (Model model) {
		
		//Mandamos un atributo de usuario
		model.addAttribute("usuario", new Usuario());
		

		return "RegistroUsuario";
	}
	
	
	@PostMapping("/regUsuario/grabar")
	public String grabarRegistroUsuario(Model model,@ModelAttribute Usuario usuario) {
		
		try {
			repoUsuario.save(usuario);
			model.addAttribute("mensajeConfirmacion", "¡Registrado correctamente!");
			
			System.out.println(model);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mensajeFallido", "Registro de manera incorrecta.");
			
			System.out.println(model);
		}
			
		return "RegistroUsuario";
		
	}
	
	/*****************FIN REGISTRAR******************/
	
	/***************LISTADO DE USUARIOS**************/
	
	@GetMapping("/usuarios/listado")
	public String ListadoUsuarios(Model model) {
		
		model.addAttribute("listadoUsuarios", repoUsuario.findAll());
		
		return "ListadoUsuarios";
	}
	
	@PostMapping("/usuarios/editar")
	public String editarUsuarios(Model model, @ModelAttribute Usuario usuario) {
		
		//
		model.addAttribute("usuario", repoUsuario.findById(usuario.getCodigo()));
		
		return "MantUsuarios";
	}
	
	@PostMapping("/usuarios/grabarEdit")
	public String grabarEditUsuario(Model model,@ModelAttribute Usuario usuario) {
		
		try {
			repoUsuario.save(usuario);
			model.addAttribute("mensajeConfirmacion", "¡Registrado correctamente!");
			
			System.out.println(model);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mensajeFallido", "Registro de manera incorrecta.");
			
			System.out.println(model);
		}
			
		return "redirect:/usuarios/listado";
		
	}
	
	@PostMapping("/usuarios/eliminar")
	public String eliminarUsuarios(Model model, @ModelAttribute Usuario usuario) {
		
		repoUsuario.deleteById(usuario.getCodigo());
		
		return "redirect:/usuarios/listado";
	}
	
}

