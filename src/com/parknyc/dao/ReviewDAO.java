package com.parknyc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.parknyc.entities.Review;

public class ReviewDAO implements ReviewDAOI {
	
	String persistenceUnitName = "ParkNYC";
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@Override
	public int addReview (Review review) {
		int result = 0;
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(review);
			em.getTransaction().commit();
			result = 1;
		} catch(Exception e ) {
			e.printStackTrace();
			result = 0;
		} finally {
			em.close();
			emf.close();
		}
		return result;
	}
	
	@Override
	public Review deleteReview(int reviewID) {
		Review deleteReview = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			deleteReview = em.find(Review.class, reviewID);
			em.remove(deleteReview);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return deleteReview;
	}
}
