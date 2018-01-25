package views.adapters;

import components.*;
import model.Restaurant;
import views.MapElement;

public class RestaurantMapElement extends Restaurant implements MapElement
{
	private GPS gps = new GPS();
	
	public RestaurantMapElement(String name, String address, String phone)
	{
		super(name, address, phone);
	}

	@Override
	public String getTitle() 
	{
		return "Restaurante: " + getName();
	}

	@Override
	public Coordinates getCoordinates() 
	{
		return gps.getCoordinates(getAddress());
	}

	@Override
	public String getHTMLInfo() 
	{
		return getName() + "\n" + getAddress() + "\n" + getPhone();
	}

	@Override
	public void open() 
	{
		call();
	}
}
