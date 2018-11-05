import java.io.*;

import encuesta.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Pregunta encuesta = new Pregunta("¿Está a favor de la energia nuclear?");

		TextUserInterface userInterface = new TextUserInterface();
		userInterface.rellena(encuesta);
	}

}

