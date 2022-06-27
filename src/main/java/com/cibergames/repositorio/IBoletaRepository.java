package com.cibergames.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.Boleta;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {
	//
	
	//Metodo para listar boletas por usuario
	List<Boleta> findByCodigoUsuario (int codigoUsuario);
}
