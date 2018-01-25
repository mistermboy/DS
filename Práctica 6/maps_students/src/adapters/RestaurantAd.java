package adapters;

import model.Restaurant;
import views.MapElement;
import components.Coordinates;
import components.GPS;

public class RestaurantAd implements MapElement {
	
	private Restaurant restaurant;
	private GPS gps = new GPS();
	
	public RestaurantAd(Restaurant restaurant){
		this.restaurant= restaurant;
	}

	@Override
	public String getTitle() {
		return this.restaurant.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.gps.getCoordinates(this.restaurant.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return this.restaurant.getPhone();
	}

	@Override
	public void open() {
		this.restaurant.call();
	}

}
