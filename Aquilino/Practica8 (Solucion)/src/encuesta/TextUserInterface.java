package encuesta;
import java.io.*;

public class TextUserInterface {

	public void rellena(Pregunta encuesta) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Comandos:");
		System.out.println("si");
		System.out.println("no");
		System.out.println("exit (para terminar)");

		do {
			System.out.println("\nPregunta: " + encuesta.getPregunta());
			System.out.print(">");

			String[] line = in.readLine().split(" ");
			// No se comprueba que el n�mero de palabras sea el adecuado

			if (line[0].equals("exit"))
				return;

			if (line[0].equals("si"))
				encuesta.incrementaSi();

			if (line[0].equals("no"))
				encuesta.incrementaNo();
		} while (true);

	}

	private static BufferedReader in;
}

