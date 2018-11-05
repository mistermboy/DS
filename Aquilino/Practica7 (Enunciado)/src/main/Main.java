package main;
import java.io.*;

import fileSystem.FileSystem;

public class Main {

	public static void main(String[] args) throws IOException {

		FileSystem fs = new FileSystem();

		fs.copyFile("privado.txt", "copia.txt");
		fs.sendToInternet("privado.txt", "156.17.11.196");
		fs.sendWithBluetooth("privado.txt", "Galaxy de Raúl");
	}

}
