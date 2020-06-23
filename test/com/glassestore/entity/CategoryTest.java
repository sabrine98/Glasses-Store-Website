package com.glassestore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class CategoryTest {

	public static void main(String[] args) {
		Category newCat = new Category("Gucci");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GlassesStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(newCat);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A Category object was persisted");
	}

}
