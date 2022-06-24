package com.cibergames.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_tipo_juego")
public class TipoJuego {
	@Id
	private int codigo_tipo_juego;
	private String nombre_tipo_juego;
}
