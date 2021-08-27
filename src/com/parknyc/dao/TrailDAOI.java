package com.parknyc.dao;

import java.util.List;

import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;

public interface TrailDAOI {

	public List<Trail> getAllTrails();
	public List<Trail> getAllTrailsByPark(String parkName);
	public List<Trail> getTrailByName(String trailName);
//	public Trail getTrailByName(String trailName);
	public Trail getTrail(int trailID);
	public List<Review> getTrailReviews(int trailID);
	public List<Trail> getTrails(String input);

	
	
}
