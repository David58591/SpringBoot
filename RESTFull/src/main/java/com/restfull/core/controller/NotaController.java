package com.restfull.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.core.entity.Nota;
import com.restfull.core.model.MNota;
import com.restfull.core.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {
	
	@Autowired
	@Qualifier("servicio")
	NotaService service;
	
	@PutMapping("/nota")
	public boolean agregarNota(@Validated @RequestBody Nota nota ) {
		return service.crear(nota);
		
	}
	
	@PostMapping("/nota")
	public boolean actualizarNota(@Validated @RequestBody Nota nota ) {
		return service.actualizar(nota);
	}
	
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") Long id,@PathVariable("nombre") String nombre) {
		return service.borrar(nombre, id);
	}
	
	@GetMapping("/notas")
	public List<MNota> obtenerNotas(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
}
