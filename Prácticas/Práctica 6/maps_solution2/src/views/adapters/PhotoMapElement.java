package views.adapters;

import components.Coordinates;
import model.Photo;
import views.MapElement;

public class PhotoMapElement extends Photo implements MapElement
{	
	public PhotoMapElement(String description, String user, Coordinates coordinates)
	{
		super(description, user, coordinates);
	}

	@Override
	public String getTitle() 
	{
		return "Foto: " + getDescription();
	}

	@Override
	public Coordinates getCoordinates() 
	{
		return getCoordinates();
	}

	@Override
	public String getHTMLInfo() 
	{
		return getDescription() + " (foto de " + getUser() + ")";
	}

	@Override
	public void open() 
	{
		show();
	}
}
