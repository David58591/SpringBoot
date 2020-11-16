package com.restfull.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Nota")
@Entity
public class Nota implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	@Column(name = "ID_NOTA")
	private Long id;
	
	@Column(name = " NOMBRE")
	private String nombre;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "CONTENIDO")
	private String contenido;
	
}
