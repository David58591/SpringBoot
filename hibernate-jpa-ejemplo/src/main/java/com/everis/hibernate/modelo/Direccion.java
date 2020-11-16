package com.everis.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "DIRECCION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Direccion {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "LOCALIDAD")
	private String localidad;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "PAIS")
	private String pais;

	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)
	private Empleado empleado;
	
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", pais=" + pais + ", empleado=" + empleado.getCodigo() + "]";
	}

}
