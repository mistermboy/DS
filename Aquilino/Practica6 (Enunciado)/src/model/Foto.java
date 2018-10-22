package model;

import google.maps.Coordenadas;

public class Foto {

	private String usuario; // Usuario que ha subido la foto
	private String descripción;
	private Coordenadas coordenadas; // Coordenadas GPS de la foto

	public Foto(String usuario, String descripción, Coordenadas coordenadas) {
		setUsuario(usuario);
		setDescripción(descripción);
		setCoordenadas(coordenadas);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	// Baja la foto
	public void descargar() {
		System.out.println("Bajando foto: " + descripción);
	}

}
