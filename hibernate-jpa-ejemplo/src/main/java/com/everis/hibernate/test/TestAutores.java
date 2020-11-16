package com.everis.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.hibernate.modelo.Autor;
import com.everis.hibernate.modelo.Libro;

public class TestAutores {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

	public static void main(String[] args) {

		crearDatos();
		imprimirDatos();
	}

	protected static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		Autor autor = em.find(Autor.class, 2L);
		
		System.out.println("este es mi autor numero "+ autor.getId() +":" + autor);
		
		List<Libro> libros = autor.getLibros();
	
		for(Libro libro : libros) {
			System.out.println("* "+ libro);
		}
		em.close();
	}	

	protected static void crearDatos() {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Autor autor1 = new Autor(1L,"Pablo Pérez","Española");
		Autor autor2 = new Autor(2L,"Elena Gómez","Mexicana");
		Autor autor3 = new Autor(3L,"Miguel López","Chilena");
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		
		em.persist(new Libro(1L,"Programar en java es facil",autor2));
		em.persist(new Libro(2L,"¿Cómo vestirse con estilo?",autor3));
		em.persist(new Libro(3L,"¿Cómo cocinar sin quemar la cocina?",autor1));
		em.persist(new Libro(4L,"Programar en Cobol es divertido",autor2));
		em.persist(new Libro(5L,"Programar en Cobol no es divertido",autor2));
		em.getTransaction().commit();

		em.close();

	}

}
