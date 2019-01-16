package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import actions.Disable;
import actions.EmergencyService;
import actions.Forecast;
import actions.OrderCoffe;
import actions.OrderGillete;
import actions.TellTheTime;
import config.Configurator;
import dash.Dash;
import simulator.Simulator;

/**
 * Ahora se permite configurar desde el main el número de botones con sus
 * respectivas acciones predeterminadas así como las acciones disponibles en la
 * configuración
 * 
 * El main representa al Cliente, el cual solo tiene que interactuar
 * exclusivamente con los contextos (en este caso Dash y Configurator)
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {

		// Acciones disponibles
		Disable disable = new Disable();
		OrderCoffe orderCoffe = new OrderCoffe();
		TellTheTime tellTheTime = new TellTheTime();
		OrderGillete orderGillete = new OrderGillete();
		EmergencyService emergencyService = new EmergencyService();
		Forecast forecast = new Forecast();

		// Configuramos el dash con el número de botones que queramos
		// y con sus acciones predefinidas
		Dash dash = new Dash();

		dash.addAction(orderCoffe);
		dash.addAction(disable);
		dash.addAction(tellTheTime);

		// Añadimos de manera sencilla las dos nuevas acciones pedidas en el enunciado
		// al dash
		dash.addAction(emergencyService);
		dash.addAction(forecast);

		// Añadimos todas las acciones posibles a configurar
		Configurator configurator = new Configurator();

		configurator.addAction(disable);
		configurator.addAction(orderCoffe);
		configurator.addAction(tellTheTime);
		configurator.addAction(orderGillete);

		// Añadimos de manera sencilla las dos nuevas acciones pedidas en el enunciado a
		// la configuración

		configurator.addAction(emergencyService);
		configurator.addAction(forecast);

		// Permitimos borrar de manera sencilla botones del dash con su correspondiente
		// acción en caso de que fuese necesario
		// dash.removeAction(disable);

		// Así como borrar acciones de la configuración
		// configurator.removeAction(forecast);

		// Ejecutamos la aplicación pasándole los botones y la configuración
		menu(dash, configurator);
	}

	public static void menu(Dash dash, Configurator configurator) throws IOException {
		Simulator simulator = new Simulator();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("\n===========================");
			System.out.println("MENU PRINCIPAL. Elija opción:");
			System.out.println("    1. Simular Dash");
			System.out.println("    2. Reprogramar botón del Dash");
			System.out.println("    S. Salir");
			System.out.print("> ");

			String line = in.readLine();
			if (line.equals("1"))
				simulator.simulate(dash);
			else if (line.equals("2"))
				configurator.configure(dash);
			else if (line.toUpperCase().equals("S"))
				return;
			else
				System.out.println("Opción desconocida");

		} while (true);
	}

}
