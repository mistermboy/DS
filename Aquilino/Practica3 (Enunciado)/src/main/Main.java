package main;

import java.io.*;

import editor.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	public void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		Editor editor = new Editor(new Dibujo());

		System.out.println("Comandos Herramientas: cuadrado, circulo, triangulo, seleccion");
		System.out.println("Comandos Ratón: pinchar x,y / mover x,y / soltar x,y");
		System.out.println("Otros Comandos: dibujar, exit");

		do {
			System.out.print(">");
			String[] line = in.readLine().split("[ ,]");

			if (line[0].equals("exit"))
				return;
			if (line[0].equals("cuadrado"))
				; //	editor.xxx
			else if (line[0].equals("circulo"))
				; //	editor.xxx
			else if (line[0].equals("triangulo"))
				; //	editor.xxx
			else if (line[0].equals("seleccion"))
				; //	editor.xxx
			else if (line[0].equals("pinchar")) {
				int x = Integer.parseInt(line[1]);
				int y = Integer.parseInt(line[2]);
				//	editor.xxx
			} else if (line[0].equals("mover")) {
				int x = Integer.parseInt(line[1]);
				int y = Integer.parseInt(line[2]);
				//	editor.xxx
			} else if (line[0].equals("soltar")) {
				int x = Integer.parseInt(line[1]);
				int y = Integer.parseInt(line[2]);
				//	editor.xxx
			} else if (line[0].equals("dibujar"))
				editor.dibujar();
			else
				System.out.println("Comando no válido");

		} while (true);
	}

	private BufferedReader in;

}
