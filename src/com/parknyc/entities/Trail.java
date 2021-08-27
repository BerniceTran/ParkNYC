package com.parknyc.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Trails")
public class Trail {
	
	@Id
	@Column(name="Trail_ID")
	private int id;
	@Column(name="Prop_ID")
	private String propID;
	@Column(name="Trail_Name")
	private String trailName;
	@Column(name="Location")
	private String location;
	@Column(name="Park_Name")
	private String parkName;
	@Column(name="Length")
	private String length;
	@Column(name="Difficulty")
	private String difficulty;
	@Column(name="Other_Details")
	private String details;
	@Column(name="Accessibility")
	private String accessibility;
	@Column(name="Limited_Acess")
	private String limitedAccess;
	@Column(name="lat")
	private String lat;
	@Column(name="lon")
	private String lon;
	@Column(name="Image")
	private String image;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="trail")
	private List<Review> reviews;
	
	public Trail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trail(int id, String propID, String trailName, String location, String parkName, String length,
			String difficulty, String details, String accessibility, String limitedAccess, String lat, String lon,
			String image, List<Review> reviews) {
		super();
		this.id = id;
		this.propID = propID;
		this.trailName = trailName;
		this.location = location;
		this.parkName = parkName;
		this.length = length;
		this.difficulty = difficulty;
		this.details = details;
		this.accessibility = accessibility;
		this.limitedAccess = limitedAccess;
		this.lat = lat;
		this.lon = lon;
		this.image = image;
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropID() {
		return propID;
	}

	public void setPropID(String propID) {
		this.propID = propID;
	}

	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public String getLocation() {
		if (location == null)
			return "Unavailable";
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getLength() {
		if (length == null) 
			return "Unknown Length";
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDifficulty() {
		if (difficulty == null) 
			return "Unknown Difficulty";
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAccessibility() {
		if (accessibility.equals("Y")) return "Yes";
		else if (accessibility.equals("Y")) return "No";
		return "No";
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	public String getLimitedAccess() {
		return limitedAccess;
	}

	public void setLimitedAccess(String limitedAccess) {
		this.limitedAccess = limitedAccess;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessibility == null) ? 0 : accessibility.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((limitedAccess == null) ? 0 : limitedAccess.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((propID == null) ? 0 : propID.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((trailName == null) ? 0 : trailName.hashCode());
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
		Trail other = (Trail) obj;
		if (accessibility == null) {
			if (other.accessibility != null)
				return false;
		} else if (!accessibility.equals(other.accessibility))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (limitedAccess == null) {
			if (other.limitedAccess != null)
				return false;
		} else if (!limitedAccess.equals(other.limitedAccess))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		if (propID == null) {
			if (other.propID != null)
				return false;
		} else if (!propID.equals(other.propID))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (trailName == null) {
			if (other.trailName != null)
				return false;
		} else if (!trailName.equals(other.trailName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trail [id=" + id + ", propID=" + propID + ", trailName=" + trailName + ", location=" + location
				+ ", parkName=" + parkName + ", length=" + length + ", difficulty=" + difficulty + ", details="
				+ details + ", accessibility=" + accessibility + ", limitedAccess=" + limitedAccess + ", lat=" + lat
				+ ", lon=" + lon + ", image=" + image + "]";
	}
	
}
