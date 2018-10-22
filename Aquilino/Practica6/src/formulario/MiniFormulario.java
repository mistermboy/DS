package formulario;

import java.io.*;

import model.Monumento;

/* Formulario básico para usar cuando se quieran pedir solo dos valores sobre algo */
public class MiniFormulario {

	public void editar(Monumento monumento) {

		System.out.println("Editando Monumento.");

		System.out.println("Valores actuales:");
		imprimeMonumento(monumento);

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print("- Autor: ");
		String texto = getLínea();
		if (texto.length() > 0)
			monumento.setAutor(texto);

		System.out.print("- Dirección: ");
		texto = getLínea();
		if (texto.length() > 0)
			monumento.setDirección(texto);

		System.out.println("Valores finales:");
		imprimeMonumento(monumento);
	}

	private void imprimeMonumento(Monumento monumento) {
		System.out.println("- Autor = " + monumento.getAutor());
		System.out.println("- Dirección = " + monumento.getDirección());
	}

	private String getLínea() {
		do {
			try {
				return consola.readLine();
			} catch (IOException ex) {
				System.out.println("Error de lectura. Inténtelo de nuevo.");
			}
		} while (true);
	}

	BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
}
