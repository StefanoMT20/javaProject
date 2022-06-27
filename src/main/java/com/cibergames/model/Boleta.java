package com.cibergames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_boleta")
public class Boleta {
	
	@Id
	@Column(name="cod_boleta")
	private int codigoBoleta;
	
	@Column(name="codigo_usu")
	private int codigoUsuario;
	
	
	@Column(name="codigo_cliente")
	private int codigoCliente;
	
	@Column(name="fecha_emision")
	private String fechaEmision;
	
	@Column(name="pago_total")
	private double totalPagar;
	
	@ManyToOne
	@JoinColumn(name="codigo_usu", insertable=false, updatable=false)
	private Usuario usuario; //atributo solo para la consulta
	
	@ManyToOne
	@JoinColumn(name="codigo_cliente", insertable=false, updatable=false)
	private Cliente cliente; //atributo solo para la consulta
}
