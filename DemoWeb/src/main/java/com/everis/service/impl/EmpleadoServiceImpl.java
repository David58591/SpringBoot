package com.everis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.everis.repository.EmpleadoRepoJPA;
import com.everis.repository.entity.Empleado;
import com.everis.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
		EmpleadoRepoJPA empleadoDAO;	
	
		
	@Override
	public void registrar(String name) {
		empleadoDAO.registrar( name );		
	}

	@Override
	public List<Empleado> listar() {
		
		return empleadoDAO.findAll();
		
	}

	@Override
	public List<Empleado> listarFiltroNombre(String cad) {
		
		return empleadoDAO.listarCuyoNombreContiene(cad);
	}

	@Override
	public List<Empleado> listarConJPA(Integer pID,String contiene) {
		
		return empleadoDAO.findByIdGreaterThanAndNombreLike(pID,contiene);
	}

	@Override
	public void inserta(Empleado emp) {
		empleadoDAO.save(emp);
		
	}

}
