package com.restfull.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restfull.core.converter.Convertidor;
import com.restfull.core.entity.Nota;
import com.restfull.core.model.MNota;
import com.restfull.core.repository.INota;

@Service("servicio")
public class NotaService {

	@Autowired
	@Qualifier("repositorio")
	private INota repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Log logger = LogFactory.getLog(NotaService.class); 
	public boolean crear(Nota nota) {
		logger.info("creando Nota");
		try {
			repositorio.save(nota);
			logger.info("Nota insertada en base de datos");
			return true;
		}catch (Exception e) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	public boolean actualizar(Nota nota) {
		try {
			if(repositorio.save(nota)!=null) {
				repositorio.save(nota);
			}else {
				System.out.println("No se puede actualizar pq no se ha pasado una nota");
			}
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public boolean borrar(String nombre, long id) {
		logger.warn("BORRANDO NOTA");
		try {
			Nota nota = repositorio.findByNombreAndId(nombre,id);
			repositorio.delete(nota);
			logger.info("Se ha borrado correctamente la nota");
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public List<MNota> obtener() {
		return this.convertidor.convertirLista(repositorio.findAll());
	}
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){
		return this.convertidor.convertirLista(repositorio.findByTitulo(titulo)); 
	}
	
	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}
