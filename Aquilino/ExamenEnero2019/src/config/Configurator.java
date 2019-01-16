package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import actions.Action;
import dash.Dash;

/**
 * Se ha añadido una lista dinámica para permitir al usuario configurar las
 * acciones permitidas a su antojo
 *
 * Esta clase ya no tiene que preocuparse de que acción enviar en función del
 * botón que ha pulsado el usuario ya que la clase ya ha sido configurada con
 * unas acciones determinadas desde el Main
 * 
 * Esta clase representa un Contexto en el patrón Strategy
 *
 */

public class Configurator {
	public void configure(Dash dash) throws IOException {
		System.out.println("\n----------------------------------------------------------");
		System.out.println("CONFIGURADOR");
		System.out.println(dash);

		try {
			System.out.println("Escriba el número de botón a cambiar:");
			int button = Integer.parseInt(in.readLine());
			if (button < 0 || button >= dash.buttonsCount()) {
				System.out.println("No es un número de botón válido: operación cancelada");
				return;
			}

			System.out.println("Escriba el número de acción a asignar al botón de entre las siguientes:");
			printActions();
			System.out.print("> ");
			String line = in.readLine();

			// Si no, es que tiene que tratarse de una acción existente
			int actionNumber = Integer.parseInt(line);
			if (actionNumber < 0 || actionNumber >= actions.size()) {
				System.out.println("No es una acción válida: operación cancelada");
				return;
			}

			// Eliminamos lógica condicional
			dash.changeButton(button, actions.get(actionNumber));

			System.out.println("Botón asignado");

		} catch (NumberFormatException e) {
			System.out.println("Se esperaba un número");
		}
	}

	private void printActions() {

		// Ya no es necesario hardcodear las acciones
		// Ahora el número de acciones puede cambiar y no es necesario modifciar el
		// código
		for (int i = 0; i < actions.size(); i++) {
			System.out.println(i + ":" + actions.get(i).getInfo());
		}

	}

	public void addAction(Action action) {
		actions.add(action);
	}

	public void removeAction(Action action) {
		actions.remove(action);
	}

	private List<Action> actions = new ArrayList<Action>();

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

}
