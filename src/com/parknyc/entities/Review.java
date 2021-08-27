package com.parknyc.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Basic 
	private String review;
	@Basic
	private int rating; 
	
	private User user;

	private Trail trail;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Review(int id, String review, int rating, User user, Trail trail) {
		super();
		this.id = id;
		this.review = review;
		this.rating = rating;
		this.user = user;
		this.trail = trail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUser() {
		return user.getFirstName();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + rating;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((trail == null) ? 0 : trail.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		if (rating != other.rating)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (trail == null) {
			if (other.trail != null)
				return false;
		} else if (!trail.equals(other.trail))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", rating=" + rating + ", user=" + user + ", trail=" + trail
				+ "]";
	}

	
}