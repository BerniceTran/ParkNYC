package com.parknyc.services;

import java.util.List;

import com.parknyc.dao.TrailDAO;
import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;

public class TrailServices {
	
	private TrailDAO traildao = new TrailDAO();
	
	public Trail getTrail(int id) {
		Trail trail = traildao.getTrail(id);
		return trail;
	}
	
	public List<Trail> getAllTrails() {
		List<Trail> trailsList = traildao.getAllTrails();
		return trailsList;
	}
	
	public List<Trail> getTrails(String input) {
		List<Trail> trailsList = traildao.getTrails(input);
		return trailsList;
	}
	
	public List<Trail> getAllTrailsByPark(String park) {
		List<Trail> trailsList = traildao.getAllTrailsByPark(park);
		return trailsList;
	}
	
	public List<Trail> getTrail(String name) {
		List<Trail> trail = traildao.getTrailByName(name);
		return trail;
	}
	
//	public Trail getTrail(String name) {
//		Trail trail = traildao.getTrailByName(name);
//		return trail;
//	}
	
	public List<Review> getTrailReviews(int trailID) {
		List<Review> trailReviews = traildao.getTrailReviews(trailID);
		return trailReviews;
	}
}
