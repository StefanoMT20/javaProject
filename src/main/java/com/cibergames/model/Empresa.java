package com.cibergames.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="tb_empresa")
public class Empresa {
	@Id
	private int codigo_empresa;
	private String nombre_empresa;
}
