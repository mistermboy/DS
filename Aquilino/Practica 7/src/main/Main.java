package main;

import java.io.IOException;

import outputs.Bluetooth;
import outputs.CopyFile;
import outputs.Internet;
import outputs.decorators.Comb;
import outputs.decorators.Counter;
import outputs.decorators.Encript;
import outputs.decorators.Normalice;
import outputs.decorators.RepeatedSpaces;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		fs.copy("privado.txt", new CopyFile("copia.txt"));
		fs.copy("privado.txt", new Internet("156.17.11.196"));
		fs.copy("privado.txt", new Encript(new Bluetooth("Galaxy de Raúl")));

		// MODIFICATION 1
		fs.copy("privado.txt", new CopyFile("a.txt"));
		fs.copy("privado.txt", new Encript(new CopyFile("a.txt")));

		// MODIFICATION 2
		fs.copy("privado.txt", new Normalice(new Internet("1.1.1.1")));
		fs.copy("privado.txt", new RepeatedSpaces(new Internet("1.1.1.1")));
		fs.copy("privado.txt", new Normalice(new RepeatedSpaces(new Internet("1.1.1.1"))));

		// MODIFICATION 3
		Counter counter;

		counter = new Counter(new CopyFile("c.txt"));
		fs.copy("privado.txt", counter);
		System.out.println("Se han enviado " + counter.getCounter() + " caracteres");

		counter = new Counter(new Internet("1.1.1.1"));
		fs.copy("privado.txt", counter);
		System.out.println("Se han enviado " + counter.getCounter() + " caracteres");

		counter = new Counter(new Bluetooth("Aquilino´s Device"));
		fs.copy("privado.txt", counter);
		System.out.println("Se han enviado " + counter.getCounter() + " caracteres");

		// MODIFICATION 4
		Counter antes = new Counter(new Internet("1.1.1.1"));
		Counter despues = new Counter(new Normalice(antes));
		
		fs.copy("privado.txt", antes);
		fs.copy("privado.txt", despues);
		
		System.out.println(antes.getCounter());
		System.out.println(despues.getCounter());
		
		// MODIFICATION 5
		fs.copy("privado.txt", new Encript(new Comb(new Internet("1.1.1.1"), new Bluetooth("Aquilino´s Device"))));
		
	}

}
