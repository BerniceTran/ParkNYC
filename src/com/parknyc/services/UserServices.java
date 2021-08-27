package com.parknyc.services;

import java.util.List;

import com.parknyc.dao.UserDAO;
import com.parknyc.entities.Review;
import com.parknyc.entities.User;

public class UserServices {

	private UserDAO userdao = new UserDAO();
	
	public boolean createUser(User user) {
		boolean result = false;
		result = userdao.addUser(user) == 1;
		return result; 
	}
	
	public User getUser(String email) {
		return userdao.getUserByEmail(email);
	}
	
	public boolean validateUser(String email, String password) {
		return userdao.validateUser(email, password);
	}
	
	public List<Review> getReviews(int userID) {
		return userdao.getTrailReviews(userID);
	}
}
