package com.parknyc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;
import com.parknyc.entities.User;

public class UserDAO implements UserDAOI {
	
	String persistenceUnitName = "ParkNYC";
	EntityManagerFactory emf = null;
	EntityManager em = null;

	@Override
	public int addUser(User user) {
		int result = 0;
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(user);
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
	public int updateUser(String id, User newUser) {
		int result = 0;
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			User currentUser = em.find(User.class, id);
			if (currentUser != null) {
				em.getTransaction().begin();
				currentUser.setEmail(newUser.getEmail());
				currentUser.setPassword(newUser.getPassword());
				currentUser.setFirstName(newUser.getFirstName());
				em.getTransaction().commit();
				result = 1;
			}
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
	public User deleteUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			if (email != null) {
				String statement = "SELECT u FROM User u WHERE u.email = :email";
				Query query = em.createQuery(statement);
				query.setParameter("email", email);
				user = (User) query.getSingleResult();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return user;
	}

	@Override
	public boolean validateUser(String email, String password) {
		User userExist = new User();
		boolean result = false;

		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			if (email != null && password != null) {
				String statement = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
				Query query = em.createQuery(statement);
				query.setParameter("email", email); //setting email value to parameter email and then setting that to u.sEmail
				query.setParameter("password", password);
				userExist = (User) query.getSingleResult();
				
				result = true;
			}
		} catch (NoResultException e) {
			result = false;
		} finally {
			em.close();
			emf.close();
		}
		
		return result;
	}
	
	@Override
	public List<Review> getTrailReviews(int userID) {
		List<Review> trailReviews = new ArrayList<Review>();
		
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
		
		try {
			User user = em.find(User.class, userID);
			trailReviews = user.getReviews();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();	
			emf.close();
		}
		
		return trailReviews;
	}
	
}










