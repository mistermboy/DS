package main;

import database.Database;
import google.maps.*;
import model.*;

public class Main {

	public static void main(String[] args) {

		Database db = new Database();
		Mapa map = new Mapa();

		// 1. Meter elementos en el mapa
		System.out.println("\n 1. Metiendo marcadores en el mapa");

		for (Monumento monumento : db.selectMonumentos()) {
			// map.add(monumento);
		}

		for (Foto foto : db.selectFotos()) {
			// map.add(foto);
		}

		for (Restaurante restaurante : db.selectRestaurantes()) {
			// map.add(restaurante);
		}

		// 2. En el mapa se dibujan los marcadores para los elementos a�adidos al mapa
		System.out.println("\n 2. Dibujando el mapa con los marcadores");
		map.dibujar();

		// 3. El usuario presiona brevemente la pantalla para recibir informaci�n de
		// cada elemento
		System.out.println("\n 3. Pulsaci�n breve sobre cada elemento: informaci�n en tooltip");
		map.pulsaci�nCorta(11, 11); // Pulsado en Monumento: Nombre y autor del monumento (coliseo)
		map.pulsaci�nCorta(21, 21); // Pulsado en Foto: Descripci�n de la foto y usuario que la ha subido
		map.pulsaci�nCorta(31, 31); // Pulsado en Restaurante: Nombre y tel�fono del restaurante

		// 4. El usuario deja pulsado un marcador para abrir un elemento
		System.out.println("\n 4. Pulsaci�n larga sobre cada elemento: abrir el elemento");
		map.pulsaci�nLarga(11, 11); // Pulsado en Monumento: Navegar hasta el coliseo con el GPS
		map.pulsaci�nLarga(21, 21); // Pulsado en Foto: Bajarse foto
		map.pulsaci�nLarga(31, 31); // Pulsado en R: Llamar al restaurante
	}

}
