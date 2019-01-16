package simulator;

import java.io.*;

import dash.*;

//No se ha modificado nada ya que no ha sido necesario
public class Simulator {
	public void simulate(Dash dash) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n----------------------------------------------------------");
		System.out.println("SIMULADOR. Simulando Dash de " + dash.buttonsCount() + " botones");
		System.out.print(dash);
		System.out.println("S. Salir");
		do {
			System.out.print("> ");
			String line = in.readLine();

			if (line.toUpperCase().equals("S"))
				return;

			try {
				int button = Integer.parseInt(line);
				if (button < 0 || button >= dash.buttonsCount()) {
					System.out.println("No es un número de botón válido");
					continue;
				}
				dash.pressButton(button);
			} catch (NumberFormatException e) {
				System.out.println("Opción desconocida");
			}
		} while (true);
	}
}
