package com.everis.hibernate.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data 
@Entity
@Table(name = "TBL_EMPLEADO")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "COD_EMPLEADO")
	private Long codigo;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	public Empleado() {
		
	}

	public Empleado(Long codigo, String apellidos, String nombre, LocalDate fechaNacimiento) {
	
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
}
