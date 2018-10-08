package form;

import form.validators.NumberValidator;
import form.validators.PredefinedValidator;
import form.validators.TextValidator;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new TextValidator()));
		formulario.addCampo(new Campo("Apellido", new TextValidator()));
		formulario.addCampo(new Campo("Teléfono", new NumberValidator()));
		formulario.addCampo(new Campo("Ciudad", new PredefinedValidator("Santander", "Oviedo", "Cádiz")));

		formulario.PideDatos();
	}
}
