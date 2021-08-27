package com.parknyc.dao;

import java.util.List;

import com.parknyc.entities.Review;

public interface ReviewDAOI {
	
	int addReview(Review review);
	Review deleteReview(int reviewID);
	

}
