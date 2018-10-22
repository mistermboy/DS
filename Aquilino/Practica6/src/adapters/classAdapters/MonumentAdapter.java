package adapters.classAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Monumento;

public class MonumentAdapter extends Monumento implements Marcador {

	private Navegador gps;

	public MonumentAdapter(String nombre, String autor, String dirección) {
		super(nombre, autor, dirección);
		gps = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return gps.getCoordenadas(getDirección());
	}

	@Override
	public String getTooltipInfo() {
		return getAutor();
	}

	@Override
	public void abrir() {
		gps.navegarHasta(getDirección());
	}

}
