package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import validators.Validator;

public class Field {

	private String label;
	private String value;
	private Validator validator;

	public Field(String label, Validator validator) {
		this.label = label;
		this.validator = validator;
	}

	public void pideDatos() {

		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {

				System.out.print(label + ": ");
				value = consola.readLine();

			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!validator.isValid(value));

	}

}
