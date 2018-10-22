package adapters.classAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import model.Foto;

public class PhotoAdapter extends Foto implements Marcador {

	public PhotoAdapter(String usuario, String descripción, Coordenadas coordenadas) {
		super(usuario, descripción, coordenadas);
	}

	@Override
	public Coordenadas getCoordenadas() {
		return getCoordenadas();
	}

	@Override
	public String getTooltipInfo() {
		return getDescripción();
	}

	@Override
	public void abrir() {
		descargar();
	}

}
