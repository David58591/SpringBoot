package com.everis.hibernate.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.hibernate.modelo.Direccion;
import com.everis.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	private static  EntityManager em;
	
	private static EntityManagerFactory emf;
	public static void main(String[] args) {
		
		/**
		 * Creamos el gestor de persistencia (EM).
		 */
		emf =Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		em.createQuery("FROM Empleado").getResultList();
		
		insertInicial();
		
		imprimirTodo();
		Empleado e = em.find(Empleado.class, 10L);
		e.setDireccion(new Direccion(15L, "Calle los abedules 33", "Springfield","Oregón", "EEUU",e));
		e.setNombre("David");
		e.setApellidos("Egea");
		imprimirTodo();
		em.close();
		emf.close();
	}
	
	protected static void insertInicial() {
		Empleado e = new Empleado(10L, "Perez","Pepito",LocalDate.of(1979,6,10));
		Direccion d = new Direccion(10L, "Calle los Beerchules 33", "Nuevo México","Texas", "EEUU",e);
		em.persist(d);
		e.setDireccion(d);
		Empleado e2 = new Empleado(20L, "Romera","Kate",LocalDate.of(1972,6,5));
		Direccion d2 = new Direccion(20L, "Calle los abedules 33", "Springfield","Oregón", "EEUU",e2);
		em.persist(d2);
		e2.setDireccion(d2);
		em.getTransaction().begin();
		em.persist(e);
		em.persist(e2);
		em.getTransaction().commit();
	}
	
	protected static void imprimirTodo() {
		List<Empleado> listaEmpleados = (List<Empleado>) em.createQuery("FROM Empleado").getResultList(); 
		
		for(Empleado emp : listaEmpleados) {
			System.out.println(emp.toString());
		}
	
	}

}
