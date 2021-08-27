package com.parknyc.controller;

import java.util.List;

import com.parknyc.dao.ReviewDAO;
import com.parknyc.dao.TrailDAO;
import com.parknyc.dao.UserDAO;
import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;
import com.parknyc.entities.User;

public class Main {
	
	public static void main(String[] args) {
		
		TrailDAO traildao = new TrailDAO();
		UserDAO userdao = new UserDAO();
		ReviewDAO reviewdao = new ReviewDAO();
		
		
//		List<Trail> trails = traildao.getAllTrails();
//		
//		for(Trail trail: trails) {
//			System.out.println(trail);
//		}
		
//		List<Trail> trails = traildao.getAllTrailsByPark("Pelham Bay Park");
//		for(Trail trail: trails) {
//			System.out.println(trail.getTrailName());
//		}
		
		
//		UserDAO userdao = new UserDAO();
//		User user = new User(2, "hi@gmail.com", "password", "Hi");
//		userdao.addUser(user);
		
//		System.out.println(userdao.validateUser("bernice@gmail.com", "password"));
		
//		Review review = new Review(1, "review", 5, userdao.getUserByEmail("bernice@gmail.com"), traildao.getTrail(1));
//		System.out.println(reviewdao.addReview(review));
		
//		List<Review> trailReviews = traildao.getTrailReviews(1);
//		
//		for(Review review: trailReviews) {
//			System.out.println(review);
//		}
		
		List<Review> trailReviews = userdao.getTrailReviews(1);
		for(Review review: trailReviews) {
			System.out.println(review);
			System.out.println(review.getReview());
		}
		
	}

}
