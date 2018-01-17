package model;

import java.util.ArrayList;
import java.util.List;

import components.Coordinates;

public class ModelList {
	
	private List<Monument> monuments;
	private List<Photo> photos;
	private List<Restaurant> restaurants;
	
	
	
	public List<Monument> getMonuments(){
		monuments = new ArrayList<Monument>();
		monuments.add(new Monument("Coliseo", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia"));
		return monuments;
	}
	
	
	public List<Photo> getPhotos(){
		photos = new ArrayList<Photo>();
		photos.add(new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20)));
		return photos;
	}
	
	
	public List<Restaurant> getRestaurants(){
		restaurants = new ArrayList<Restaurant>();
		restaurants.add(new Restaurant("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643"));
		return restaurants;
	}
	
	

}
