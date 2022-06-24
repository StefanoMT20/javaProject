package com.cibergames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.TipoUsuario;


@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, String> {
	//CRUD
	//...
	
}
