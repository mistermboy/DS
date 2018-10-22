package adapters.objectAdapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import model.Foto;

public class PhotoAdapter implements Marcador {

	private Foto photo;

	public PhotoAdapter(Foto photo) {
		this.photo = photo;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return photo.getCoordenadas();
	}

	@Override
	public String getTooltipInfo() {
		return photo.getDescripción();
	}

	@Override
	public void abrir() {
		photo.descargar();
	}

}
