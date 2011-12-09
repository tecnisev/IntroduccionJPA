package com.tecnisev.IntroduccionJPA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibroAutorEjemplo 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try
		{
			emf=Persistence.createEntityManagerFactory("libros", new HashMap());
			em=emf.createEntityManager();
			em.getTransaction().begin();
		
			Autor autor = new Autor();
			autor.setautorName("Clifford Geertz");
			Autor autor1 = new Autor();
			autor1.setautorName("JP Morgenthal");
			HashSet autorSet = new HashSet();
			autorSet.add(autor);
			autorSet.add(autor1);
		
			Libro libro = new Libro();
			libro.setlibroName("Phoenix");
			Libro libro1 = new Libro();
			libro1.setlibroName("Enterprise Applications Integration with XML and Java");
		
			libro.setautors(autorSet);
			libro1.setautors(autorSet);
		
			em.persist(libro);
			em.persist(libro1);
	
			Libro libroRecord = em.find(Libro.class, libro.getId());
			System.out.println("libro: "+ libroRecord.getlibroName());
			Set<Autor> authset = libroRecord.getautors();
			Iterator it = authset.iterator();
		
			while(it.hasNext())
			{
				Autor a = (Autor)it.next();
				System.out.println("autor: "+ a.getautorName());
			}
			
			em.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			em.close();
			emf.close();
		}
	}
}