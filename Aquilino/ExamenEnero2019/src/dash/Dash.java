package dash;

import java.util.ArrayList;
import java.util.List;

import actions.Action;

/**
 * 
 * Se ha eliminado la colección estática y se ha reemplazado por una dinámica
 * para permitir al usuario añadir nuevos botones y cambiar sus respectivas
 * acciones de manera dinámica
 * 
 * El Dash ya no tiene que implementar el comportamiento específico de ninguna
 * acción, ya que delega las peticiones en sus distintas estrategias ( en este
 * caso las acciones ) que saben como satisfacerlas
 * 
 * Esta clase representa un Contexto en el patrón Strategy
 */
public class Dash {

	public Dash() {
		actions = new ArrayList<>();
	}

	public int buttonsCount() {
		return actions.size();
	}

	public void changeButton(int button, Action action) {
		checkIsValidButton(button);
		// Eliminamos la acción a sustituir
		actions.remove(button);
		// La reemplazamos por la nueva acción
		actions.add(button, action);
	}

	public void pressButton(int button) {
		checkIsValidButton(button);
		Action action = actions.get(button);
		// Eliminamos toda la lógica condicional
		action.press();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("-----------------------\n");
		buffer.append("Dash. Botones actuales:\n");
		for (int button = 0; button < buttonsCount(); button++) {
			Action action = actions.get(button);
			// Eliminamos toda la lógica condicional
			buffer.append(button + ": " + action.getInfo() + '\n');
		}
		return buffer.toString();
	}

	private void checkIsValidButton(int button) {
		if (button < 0 || button >= buttonsCount())
			throw new IllegalArgumentException("¡" + button + " no es un número de botón válido!");
	}

	public void addAction(Action action) {
		actions.add(action);
	}

	public void removeAction(Action action) {
		actions.remove(action);
	}

	public Action getAction(int button) {
		return actions.get(button);
	}

	private List<Action> actions;

}
