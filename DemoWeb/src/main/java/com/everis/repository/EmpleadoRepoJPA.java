package com.everis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.repository.entity.Empleado;

public interface EmpleadoRepoJPA extends JpaRepository<Empleado,Integer>,EmpleadoRepo {
	
	List<Empleado> findByIdGreaterThanAndNombreLike (Integer pId, String contiene);
}
