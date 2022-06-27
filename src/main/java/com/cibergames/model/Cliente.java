package com.cibergames.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_cliente")
public class Cliente {
	
	
	@Id
	private int codigo_cliente;
	
	private String nombre_cliente;
	
	private String apellido_cliente;
}
