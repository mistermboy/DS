package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader fichero = new BufferedReader(new FileReader("programa.txt"));

		Interprete interprete = new Interprete();

		String linea;
		while ((linea = fichero.readLine()) != null)
			interprete.cargaInstrucción(linea);
		fichero.close();

		interprete.ejecutaPrograma();
	}

}
