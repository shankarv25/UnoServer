package com.brozon.uno.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Place {
	
	private String _id;
	private long placeId;
	private String name;
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
	
	public long getId() {
		return placeId;
	}
	public void setId(long id) {
		this.placeId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
				+ ", type=" + type + "]";
	}


}
