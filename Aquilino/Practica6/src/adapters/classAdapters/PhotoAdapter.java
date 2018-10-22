package adapters.classAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import model.Foto;

public class PhotoAdapter extends Foto implements Marcador {

	public PhotoAdapter(String usuario, String descripci�n, Coordenadas coordenadas) {
		super(usuario, descripci�n, coordenadas);
	}

	@Override
	public Coordenadas getCoordenadas() {
		return getCoordenadas();
	}

	@Override
	public String getTooltipInfo() {
		return getDescripci�n();
	}

	@Override
	public void abrir() {
		descargar();
	}

}
