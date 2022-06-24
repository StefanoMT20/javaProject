package com.cibergames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.VideoJuego;

@Repository
public interface IVideoJuegoRepository extends JpaRepository<VideoJuego, Integer> {
	//CRUD
	//...
}
