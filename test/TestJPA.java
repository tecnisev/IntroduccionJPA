package com.tecnisev.IntroduccionJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPA {

	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select t from EjemploJPA t");
		List<EjemploJPA> todoList = q.getResultList();
		for (EjemploJPA todo : todoList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + todoList.size());

		// Create new todo
		em.getTransaction().begin();
		EjemploJPA todo = new EjemploJPA();
		todo.setSummary("This is a test");
		todo.setDescription("This is a test");
		em.persist(todo);
		em.getTransaction().commit();

		em.close();
	}
}