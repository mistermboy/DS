package form;

import form.validators.LengthValidator;
import form.validators.LessThanValidator;
import form.validators.MoreThanValidator;
import form.validators.NumberValidator;
import form.validators.PredefinedValidator;
import form.validators.TextValidator;
import form.validators.decorate.AndValidator;
import form.validators.decorate.OrValidator;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new TextValidator()));
		formulario.addCampo(new Campo("Apellido", new TextValidator()));
		formulario.addCampo(new Campo("Teléfono", new NumberValidator()));
		formulario.addCampo(new Campo("Ciudad", new PredefinedValidator("Santander", "Oviedo", "Cádiz")));

		formulario.addCampo(new Campo("Código de Producto", new LengthValidator(4)));
		formulario
				.addCampo(new Campo("Código Postal", new AndValidator(new NumberValidator(), new LengthValidator(5))));

		formulario.addCampo(new Campo("Edad", new AndValidator(new NumberValidator(), new MoreThanValidator(18))));

		formulario.addCampo(new Campo("Sueldo",
				new AndValidator(new NumberValidator(), new MoreThanValidator(800), new LessThanValidator(1200))));

		formulario.addCampo(
				new Campo("Ubicación", new OrValidator(new PredefinedValidator("Santander", "Oviedo", "Cádiz"),
						new AndValidator(new NumberValidator(), new LengthValidator(5)))));

		formulario.addCampo(new Campo("Código de Promoción",
				new OrValidator(new TextValidator(), new AndValidator(new NumberValidator(), new LengthValidator(3)))));

		formulario.PideDatos();
	}
}
