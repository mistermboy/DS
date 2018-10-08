package main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import editor.Dibujo;
import editor.Editor;
import figures.Circle;
import figures.Rectangle;
import figures.Triangle;

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
				editor.addFigure(new Rectangle());
			else if (line[0].equals("circulo"))
				editor.addFigure(new Circle());
			else if (line[0].equals("triangulo"))
				editor.addFigure(new Triangle());
			else if (line[0].equals("seleccion"))
				editor.activateSelection();
			else if (line[0].equals("pinchar")) {
				editor.pinchar(new Point(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
			} else if (line[0].equals("mover")) {
				editor.mover(new Point(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
			} else if (line[0].equals("soltar")) {
				editor.soltar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			} else if (line[0].equals("dibujar"))
				editor.dibujar();
			else
				System.out.println("Comando no válido");

		} while (true);
	}

	private BufferedReader in;

}
