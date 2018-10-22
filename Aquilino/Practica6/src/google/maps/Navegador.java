package google.maps;

public class Navegador {

	// Dada una direcci�n, devuelve sus coordenadas 
	public Coordenadas getCoordenadas(String direcci�n) {
		// Implementaci�n de relleno
		double number = (direcci�n.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordenadas(number, number);
	}

	// Dadas unas coordenadas, devuelve la direcci�n a la que le corresponde
	public String getDirecci�n(Coordenadas coordenadas) {
		// Implementaci�n de relleno
		return coordenadas.toString();
	}

	// M�todo que, dada una direcci�n, inicia el proceso de navegar hasta ella
	public void navegarHasta(String direcci�n) {
		// Implementaci�n de relleno
		System.out.println("GPS: Gire a la derecha. Ha llegado a '" + direcci�n + "'");
	}
}
