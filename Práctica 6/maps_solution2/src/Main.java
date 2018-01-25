import components.*;

import views.*;
import views.adapters.*;

public class Main 
{
	public static void main(String[] args) 
	{
		// En esta versión (adaptador de clases) hay que cambiar las llamadas
		// a los new para crear los adaptadores en vez de los objetos originales
		// (nótese que hay que cambiar también las referencias, para que se puedan
		// añadir al mapa).
		MonumentMapElement coliseo = new MonumentMapElement("Coliseo", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia");
		PhotoMapElement myPhoto = new PhotoMapElement("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20));
		RestaurantMapElement elGladiador = new RestaurantMapElement("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643");

		MapView map = new MapView();

		// 1. Meter elementos en el mapa
		System.out.println("\n 1. Se añaden varios elementos al mapa...");
		
		// Se añaden al mapa los tres elementos anteriores
		map.add(coliseo);
		map.add(myPhoto);
		map.add(elGladiador);

		// 2. En el mapa se dibujan marcadores para el coliseo, la foto y un restaurante
		System.out.println("\n 2. Se muestra el mapa:");
		
		map.draw();

		// 3. El usuario presiona brevemente la pantalla para recibir información de cada elemento
		System.out.println("\n 3. Pulsación breve sobre cada elemento: se muestra un \"tooltip\"");
		map.userTouch(160, 160); // información resumida del coliseo
		map.userTouch(22, 21);   // información de la foto
		map.userTouch(219, 221); // información del restaurante

		// 4. El usuario deja pulsado un marcador para abrir un elemento
		System.out.println("\n 4. Pulsación larga sobre cada elemento: realiza la acción predeterminada con cada elemento");
		map.userLongTouch(160, 158); // navegar hasta el coliseo con el GPS
		map.userLongTouch(19, 22);   // descargar foto
		map.userLongTouch(222, 218); // llamar al restaurante
	}
}
