package com.cibergames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.TipoJuego;

@Repository
public interface ITipoJuegoRepository extends JpaRepository<TipoJuego, Integer> {
	//CRUD
	//...
}
