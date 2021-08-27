package com.parknyc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;

public class TrailDAO implements TrailDAOI{
	
	String persistenceUnitName = "ParkNYC";
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	@Override
	public Trail getTrail(int trailID) {
		
		Trail trail = null;
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			trail = em.find(Trail.class, trailID);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return trail;
	}

	@Override
	public List<Trail> getAllTrails() {
		
		List<Trail> trailsList = new ArrayList<Trail>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			String statement = "SELECT t FROM Trail t";
			Query query = em.createQuery(statement);
			trailsList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return trailsList;	
	}
	
	@Override
	public List<Trail> getTrails(String input) {
		
		List<Trail> trailsInParkList = new ArrayList<Trail>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			String statement = "SELECT t FROM Trail t WHERE t.parkName LIKE :park OR t.trailName LIKE :trail";
			Query query = em.createQuery(statement);
			query.setParameter("park", input+"%");
			query.setParameter("trail", input+"%");
			trailsInParkList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
		return trailsInParkList;
	}

	@Override
	public List<Trail> getAllTrailsByPark(String park) {
		
		List<Trail> trailsInParkList = new ArrayList<Trail>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			String statement = "SELECT t FROM Trail t WHERE t.parkName LIKE :park";
			Query query = em.createQuery(statement);
			query.setParameter("park", park+"%");
			trailsInParkList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		
		return trailsInParkList;
	}

	@Override
	public List<Trail> getTrailByName(String trailName) {
		
		List<Trail> trails = new ArrayList<Trail>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			String statement = "SELECT t FROM Trail t WHERE t.trailName LIKE :trailName";
			Query query = em.createQuery(statement);
			query.setParameter("trailName", trailName+"%");
			trails = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();	
			emf.close();
		}
		
		return trails;
	}
	
//	@Override
//	public Trail getTrailByName(String trailName) {
//		
//		Trail trail = new Trail();
//		
//		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
//		em = emf.createEntityManager();
//		
//		try {
//			String statement = "SELECT t FROM Trail t WHERE t.trailName = :trailName";
//			Query query = em.createQuery(statement);
//			query.setParameter("trailName", trailName);
//			trail = (Trail) query.getSingleResult();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();	
//			emf.close();
//		}
//		
//		return trail;
//	}
	
	

	@Override
	public List<Review> getTrailReviews(int trailID) {
		List<Review> trailReviews = new ArrayList<Review>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			Trail trail = em.find(Trail.class, trailID);
			trailReviews = trail.getReviews();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();	
			emf.close();
		}
		
		return trailReviews;
	}
	

}
