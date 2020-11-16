package com.restfull.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restfull.core.entity.Nota;
import com.restfull.core.model.MNota;

@Component("convertidor")
public class Convertidor {

	public List<MNota> convertirLista(List<Nota> notas){
			List<MNota>mnotas = new ArrayList<MNota>();
			
			for (Nota nota : notas) {
				mnotas.add(new MNota(nota));
			}
			return mnotas ;
	}
}
