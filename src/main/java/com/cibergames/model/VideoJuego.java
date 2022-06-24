package com.cibergames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_video_juego")
public class VideoJuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_juego;
	private String nombre_juego;
	private String descripcion_juego;
	private double precio_juego;
	private String ruta_img_juego;
	private String fecha_lanzamiento;
	private int codigo_categoria;
	private int codigo_tipo_juego;
	private int codigo_empresa;
}
