package adapters.objectAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Monumento;

public class MonumentAdapter implements Marcador {

	private Monumento monument;
	private Navegador gps;

	public MonumentAdapter(Monumento monument) {
		this.monument = monument;
		gps = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return gps.getCoordenadas(monument.getDirección());
	}

	@Override
	public String getTooltipInfo() {
		return monument.getAutor();
	}

	@Override
	public void abrir() {
		// TODO Auto-generated method stub

	}

}
