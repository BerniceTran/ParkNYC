package com.parknyc.dao;

import java.util.List;

import com.parknyc.entities.Review;
import com.parknyc.entities.User;

public interface UserDAOI {
	
	public int addUser(User user);
	public int updateUser(String email, User newUser);
	public User deleteUser(String email);
	public User getUserByEmail(String email);
	public boolean validateUser(String email, String password);
	List<Review> getTrailReviews(int userID);
		

}
