package google.maps;

public class Coordenadas {

	private double longitud;
	private double latitud;

	public Coordenadas(double longitud, double latitud) {
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	@Override
	public String toString() {
		return "[longitud = " + longitud + ", latitud = " + latitud + "]";
	}

}