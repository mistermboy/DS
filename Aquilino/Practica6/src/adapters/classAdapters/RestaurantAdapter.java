package adapters.classAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

public class RestaurantAdapter extends Restaurante implements Marcador {

	private Navegador gps;

	public RestaurantAdapter(String nombre, String dirección, String teléfono) {
		super(nombre, dirección, teléfono);
		gps = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return gps.getCoordenadas(getDirección());
	}

	@Override
	public String getTooltipInfo() {
		return getNombre();
	}

	@Override
	public void abrir() {
		llamar();
	}

}
