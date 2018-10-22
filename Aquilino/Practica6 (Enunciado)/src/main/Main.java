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

		// 2. En el mapa se dibujan los marcadores para los elementos añadidos al mapa
		System.out.println("\n 2. Dibujando el mapa con los marcadores");
		map.dibujar();

		// 3. El usuario presiona brevemente la pantalla para recibir información de
		// cada elemento
		System.out.println("\n 3. Pulsación breve sobre cada elemento: información en tooltip");
		map.pulsaciónCorta(11, 11); // Pulsado en Monumento: Nombre y autor del monumento (coliseo)
		map.pulsaciónCorta(21, 21); // Pulsado en Foto: Descripción de la foto y usuario que la ha subido
		map.pulsaciónCorta(31, 31); // Pulsado en Restaurante: Nombre y teléfono del restaurante

		// 4. El usuario deja pulsado un marcador para abrir un elemento
		System.out.println("\n 4. Pulsación larga sobre cada elemento: abrir el elemento");
		map.pulsaciónLarga(11, 11); // Pulsado en Monumento: Navegar hasta el coliseo con el GPS
		map.pulsaciónLarga(21, 21); // Pulsado en Foto: Bajarse foto
		map.pulsaciónLarga(31, 31); // Pulsado en R: Llamar al restaurante
	}

}
