package adapters;

import model.Photo;
import components.Coordinates;
import views.MapElement;

public class PhotoAd implements MapElement {
	
	
	private Photo photo;
	
	public PhotoAd(Photo photo){
		this.photo = photo;
	}

	@Override
	public String getTitle() {
		return this.photo.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.photo.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return this.photo.getUser();
	}

	@Override
	public void open() {
		this.photo.show();
	}

}
