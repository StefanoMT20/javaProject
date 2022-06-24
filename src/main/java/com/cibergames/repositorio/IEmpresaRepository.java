package com.cibergames.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibergames.model.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
	//CRUD
	//...
	
}
