package com.brozon.uno.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brozon.uno.model.Place;
import com.mongodb.Mongo;

@Controller
@RequestMapping(value = "/places")
public class PlacesController {
	
	@Autowired
	public Mongo mongo;
	
	@Autowired
	public MongoOperations mongoOperations;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Place> index(HttpServletRequest request, HttpServletResponse response,
							 @RequestParam(value="search", required=false) String search,
							 @RequestParam(value="fields", required=false) List<String> fields,
							 @RequestParam(value="page", required=false) Integer page,
							 @RequestParam(value="size", required=false) Integer size) {
		
		System.out.println("Places index");
		response.addHeader("Access-Control-Allow-Origin", "*");
		Query searchQuery = constructQuery(search, fields, page, size);
		List<Place> places = mongoOperations.find(searchQuery, Place.class, "places");
		return places;
	}
	
	@RequestMapping(value = "/{placeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Place getPlace(HttpServletRequest request, HttpServletResponse response,
						  @PathVariable long placeId,
						  @RequestParam(value="fields", required=false) List<String> fields) {
		System.out.println("Place " + placeId);
		response.addHeader("Access-Control-Allow-Origin", "*");
		Query query = constructQuery(placeId, fields);
		Place place = mongoOperations.findOne(query, Place.class, "places");
		return place;
	}
	
	private Query constructQuery(long placeId, List<String> fields) {
		Query query = new Query(Criteria.where("placeId").is(placeId));
		if(fields!=null) {
			for(String field : fields) {
				query.fields().include(field);
			}
		}
		return query;
	}
	
	private Query constructQuery(String search, List<String> fields, Integer page, Integer size) {
		Query query = new Query();
		if(search!=null) {
			query.addCriteria(Criteria.where("name").regex(search, "i"));
		}
		if(fields!=null) {
			for(String field : fields) {
				query.fields().include(field);
			}
		}
		if(page!=null && size!=null) {
			query.with(new PageRequest(page,size));
		}
		return query;
	}

}
