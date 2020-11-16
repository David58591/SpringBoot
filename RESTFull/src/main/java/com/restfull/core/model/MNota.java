package com.restfull.core.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.restfull.core.entity.Nota;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MNota {
	
	
	private Long id;
	

	private String nombre;
	
	
	private String titulo;
	
	
	private String contenido;
	
	public MNota(Nota nota) {
		this.id= nota.getId();
		this.nombre= nota.getNombre();
		this.titulo = nota.getTitulo();
		this.contenido = nota.getContenido();
	}
}
