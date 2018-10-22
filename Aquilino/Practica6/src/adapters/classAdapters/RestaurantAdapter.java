package adapters.classAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

public class RestaurantAdapter extends Restaurante implements Marcador {

	private Navegador gps;

	public RestaurantAdapter(String nombre, String direcci�n, String tel�fono) {
		super(nombre, direcci�n, tel�fono);
		gps = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return gps.getCoordenadas(getDirecci�n());
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
