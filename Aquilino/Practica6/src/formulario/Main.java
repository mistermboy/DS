package formulario;

import google.maps.*;
import model.*;

public class Main {

	public static void main(String[] args) {

		Monumento monumento = new Monumento("Coliseo", "Vespasiano", "Avenida del Coliseo 1. Roma");
		Restaurante restaurante = new Restaurante("Mario", "Via della Dataria . Roma", "555 123 457");
		Foto foto = new Foto("Un perro mordiendo a un turista", "Ra�l", new Coordenadas(40, 40));
		
		MiniFormulario formulario = new MiniFormulario();
		formulario.editar(monumento);
		
		// Tarea 1. Editar tambi�n restaurante. Que se puedan editar el nombre y la direcci�n del mismo.
		
		// Tarea 2. Editar tambi�n foto. Que se puedan editar el usuario y la descripci�n de la misma.
	}

}
