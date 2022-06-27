package com.cibergames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="tb_usuario")
public class Usuario {
	@Id
	@Column(name="codigo_usu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="login_usu")
	private String correo;
	
	@Column(name="clave_usu")
	private String clave;
	
	@Column(name="nombre_usu")
	private String nombre;
	
	@Column(name="apellido_usu")
	private String apellido;
	
	@Column(name="dni_usu")
	private String dni;

}
