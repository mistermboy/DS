package adapters;

import model.Monument;
import components.Coordinates;
import components.GPS;
import views.MapElement;

public class MonumentAd implements MapElement{
	
	private Monument monument;
	private GPS gps = new GPS();
	
	public MonumentAd(Monument monument){
		this.monument = monument;
	}
	

	@Override
	public String getTitle() {
		return this.monument.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.gps.getCoordinates(this.monument.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return this.monument.getAuthor();
	}

	@Override
	public void open() {
	
		this.gps.navigateTo(this.monument.getAddress());
	}

}
