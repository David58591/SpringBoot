package com.everis.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor 
@Entity
@Table(name="AUTORES")
public class Autor {
	
	@Id
	@Column(name = "AUTOR_ID")
	 private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	
	
	
	public Autor(Long id, String nombre, String nacionalidad) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}



	@OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
	@ToString.Exclude private List<Libro> libros = new ArrayList<Libro>();
}
