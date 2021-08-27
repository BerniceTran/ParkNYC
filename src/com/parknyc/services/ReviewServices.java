package com.parknyc.services;

import com.parknyc.dao.ReviewDAO;
import com.parknyc.entities.Review;

public class ReviewServices {
	
	private ReviewDAO reviewdao = new ReviewDAO();

	public int addReview (Review review) {
		int result = reviewdao.addReview(review);
		return result;
	}
	
}
