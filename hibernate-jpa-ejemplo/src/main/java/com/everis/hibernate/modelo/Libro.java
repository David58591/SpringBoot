package com.everis.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "LIBROS")
public class Libro {
	
	@Id
	@Column(name = "LIBRO_ID")
	private Long id;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + "]";
	}
	
	
	
}
