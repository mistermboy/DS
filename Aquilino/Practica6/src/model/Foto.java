package model;

import google.maps.Coordenadas;

public class Foto {

	private String usuario; // Usuario que ha subido la foto
	private String descripci�n;
	private Coordenadas coordenadas; // Coordenadas GPS de la foto

	public Foto(String usuario, String descripci�n, Coordenadas coordenadas) {
		setUsuario(usuario);
		setDescripci�n(descripci�n);
		setCoordenadas(coordenadas);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	// Baja la foto
	public void descargar() {
		System.out.println("Bajando foto: " + descripci�n);
	}

}
