package com.restfull.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USUARIO")

@Data
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "USUARIO",unique = true)
	private String usuario;
	
	@Column(name = "CONTRASENA")
	private String contraseña;
	
	@Column(name = "ROL")
	private byte rol;
	
	@Column(name = "ACTIVO")
	private boolean activo;

	public Usuario (long id, String usuario) {
		this.id = id;
		this.usuario = usuario;
	}
}

