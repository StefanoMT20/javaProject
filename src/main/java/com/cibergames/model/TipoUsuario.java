package com.cibergames.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_tipo_usuario")
public class TipoUsuario {
	@Id
	private String codigo_tipo_usu;
	private String nombre_tipo_usu;
}
