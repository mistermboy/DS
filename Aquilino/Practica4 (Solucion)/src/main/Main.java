package main;

import validaciones.*;
import validaciones.composite.*;
import formulario.*;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new CheckText()));
		formulario.addCampo(new Campo("Apellido", new CheckText()));
		formulario.addCampo(new Campo("Teléfono", new CheckNumber()));
		formulario.addCampo(new Campo("Ciudad", new CheckValues("Santander", "Oviedo", "Cadiz")));

		// "Código de Producto". Longitud = 4
		formulario.addCampo(new Campo("Código de Producto", new CheckLength(4)));

		// "Código Postal". Digitos y longitud = 5
		formulario.addCampo(new Campo("Código Postal", new CheckAll(new CheckNumber(), new CheckLength(5))));
		formulario.addCampo(new Campo("Código Postal", new CheckCodigoPostal()));

		// "Edad". Digitos y mayor 18
		formulario.addCampo(new Campo("Edad", 
				new CheckAll(new CheckNumber(), new CheckGreater(18))));

		// "Sueldo". Digitos y mayor que 800 y menor que 1200
		formulario.addCampo(new Campo("Sueldo", 
				new CheckAll(new CheckNumber(), new CheckGreater(800), new CheckLess(1200))));

		// "Ubicación". Santander..Cádiz o código postal
		formulario.addCampo(new Campo("Ubicación", 
				new CheckAny(new CheckValues("Santander", "Oviedo", "Cádiz"), new CheckCodigoPostal())));

		// "Código de Promoción". Texto o (numero de 3 digitos)
		formulario.addCampo(new Campo("Promoción", 
				new CheckAny(
						new CheckText(), 
						new CheckAll(new CheckNumber(), new CheckLength(3)))));

		formulario.PideDatos();
	}

}
