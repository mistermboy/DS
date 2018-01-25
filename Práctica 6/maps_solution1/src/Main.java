import components.*;

import views.*;
import views.adapters.*;

import model.*;

public class Main 
{
	public static void main(String[] args) 
	{
		Monument coliseo = new Monument("Coliseo", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia");
		Photo myPhoto = new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20));
		Restaurant elGladiador = new Restaurant("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643");

		MapView map = new MapView();

		// 1. Meter elementos en el mapa
		System.out.println("\n 1. Se añaden varios elementos al mapa...");
		
		// Se añaden al mapa los tres elementos anteriores
		map.add(new MonumentMapElement(coliseo));
		map.add(new PhotoMapElement(myPhoto));
		map.add(new RestaurantMapElement(elGladiador));

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
