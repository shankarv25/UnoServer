package com.brozon.uno.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Place {
	
	private String _id;
	private Long placeId;
	private String name;
	private String description;
	private Float lattitude;
	private Float longitude;
	private Float rating;
	private String type;
	
	public Place() {
	}
	
	public Place(long id, String name) {
		this.placeId = id;
		this.name = name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getLattitude() {
		return lattitude;
	}

	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Place [_id=" + _id + ", placeId=" + placeId + ", name=" + name
				+ ", description=" + description + ", lattitude=" + lattitude
				+ ", longitude=" + longitude + ", rating=" + rating + ", type="
				+ type + "]";
	}

	
}
