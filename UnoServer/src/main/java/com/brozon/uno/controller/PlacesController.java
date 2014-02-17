package com.brozon.uno.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brozon.uno.model.Place;

@Controller
@RequestMapping(value = "/places")
public class PlacesController {
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Place> index() {
		System.out.println("Places index");
		List<Place> places = new ArrayList<Place>();
		places.add(new Place(1, "Gangtok"));
		places.add(new Place(2, "Shillong"));
		return places;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Place getPlace(@PathVariable long id) {
		System.out.println("Place " + id);
		return new Place(1, "Gangtok");
	}

}
