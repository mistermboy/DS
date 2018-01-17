package views.adapters;

import model.Monument;
import views.MapElement;
import components.*;

public class MonumentMapElement extends Monument implements MapElement 
{
	private GPS gps = new GPS();

	public MonumentMapElement(String name, String author, String address)
	{
		super(name, author, address);
	}
	
	@Override
	public String getTitle() 
	{
		return "Monumento: " + getName();
	}

	@Override
	public Coordinates getCoordinates() 
	{
		return gps.getCoordinates(getAddress());
	}

	@Override
	public String getHTMLInfo()
	{
		return getName() + ". Creado por " + getAuthor() + "\n" +
				getAddress();
	}

	@Override
	public void open() 
	{
		gps.navigateTo(getAddress());
	}
}
