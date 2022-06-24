package com.cibergames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	//CRUD
	//...
	
	
	//Metodo para validar el login
	//select * from tb_usuario where correo=? and clave=?
	Usuario findByCorreoAndClave(String correo, String clave);
}
