package main;

import java.io.*;

import fileSystem.FileSystem;
import outputs.*;
import outputs.filters.*;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		// ------------------------------------------------
		// Diseño de Referencia
		fs.copy("privado.txt", new Normalizador(new FileOutput("privado2.txt")));
		fs.copy("privado.txt", new Encriptador(new InternetOutput("1.1.1.1")));
		fs.copy("privado.txt", new Encriptador(new EliminadorDeEspacios(new BluetoothOutput("iPhone"))));

		
		
		// ------------------------------------------------
		// Modificación 1: que se pueda encriptar al escribir en fichero
		// Cambios: Ninguno
		fs.copy("privado.txt", new Normalizador(new FileOutput("a.txt")));
		fs.copy("privado.txt", new Normalizador(new Encriptador(new FileOutput("b.txt"))));

		// ------------------------------------------------
		// Modificación 2: en Internet que se pueda normalizar y/o eliminar espacios
		// Cambios: Ninguno
		fs.copy("privado.txt", new Normalizador(new InternetOutput("1.1.1.1")));
		fs.copy("privado.txt", new EliminadorDeEspacios(new InternetOutput("1.1.1.1")));
		fs.copy("privado.txt", new EliminadorDeEspacios(new Normalizador(new InternetOutput("1.1.1.1"))));

		// ------------------------------------------------
		// Modificación 3: Contar caracteres escritos
		// Cambios: Añadir clase Contador
		Contador contador = new Contador(new InternetOutput("1.1.1.1"));
		fs.copy("privado.txt", new Normalizador(contador));
		System.out.println("Modificacion 3a: " + contador.getCounter());

		// Otra forma de hacerlo:
		fs.copy("privado.txt", new Normalizador(contador = new Contador(new InternetOutput("1.1.1.1"))));
		System.out.println("Modificacion 3b: " + contador.getCounter());

		// ------------------------------------------------
		// Modificación 4: Poder contar caracteres también antes de normalizar
		// Cambios: ninguno
		Contador despues = new Contador((new InternetOutput("1.1.1.1")));
		Contador antes = new Contador(new Normalizador(despues));
		fs.copy("privado.txt", antes);
		System.out.println("Modificacion 4a: " + antes.getCounter() + " -> " + despues.getCounter());

		// Otra forma de hacerlo:
		fs.copy("privado.txt", antes = new Contador(new Normalizador(despues = new Contador((new InternetOutput("1.1.1.1"))))));
		System.out.println("Modificacion 4b: " + antes.getCounter() + " -> " + despues.getCounter());

		// ------------------------------------------------
		// Modificación 5: Se quiere que un fichero se encripte solo una vez aunque se envíe a más de un destino
		// Cambios: Añadir clase Repartidor
		fs.copy("privado.txt", new Encriptador(new Repartidor(new InternetOutput("1.1.1.1"), new BluetoothOutput("iPhone"))));

	}
}
