package adapters.objectAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

public class RestaurantAdapter implements Marcador {

	private Restaurante restaurant;
	private Navegador gps;


	public RestaurantAdapter(Restaurante restaurant) {
		this.restaurant = restaurant;
		gps = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return gps.getCoordenadas(restaurant.getDirección());
	}

	@Override
	public String getTooltipInfo() {
		return restaurant.getNombre();
	}

	@Override
	public void abrir() {
		restaurant.llamar();
	}

}
