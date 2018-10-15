package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import editor.Editor;
import editor.Tool;
import figures.circle.CircleCreationTool;
import figures.rectangle.RectangleCreationTool;
import figures.triangle.TriangleCreationTool;

public class TextInterface {

	public TextInterface(Editor editor) {
		this.editor = editor;
		this.in = new BufferedReader(new InputStreamReader(System.in));

		creaHerramientas();
	}

	private void creaHerramientas() {
		circulo = new CircleCreationTool(editor);
		cuadrado = new RectangleCreationTool(editor);
		triangulo = new TriangleCreationTool(editor);
	}

	public void run() throws IOException {
		System.out.println("Comandos Herramientas: cuadrado, circulo, triangulo, seleccion");
		System.out.println("Comandos Ratón: pinchar x,y / mover x,y / soltar x,y");
		System.out.println("Otros Comandos: dibujar, exit");
		do {
			System.out.print(">");
			String[] line = in.readLine().split("[ ,]");
			if (line[0].equals("exit"))
				return;
			if (line[0].equals("cuadrado"))
				editor.setTool(cuadrado);
			else if (line[0].equals("circulo"))
				editor.setTool(circulo);
			else if (line[0].equals("triangulo"))
				editor.setTool(triangulo);
			else if (line[0].equals("seleccion"))
				editor.setTool(editor.getDefaultTool());
			else if (line[0].equals("pinchar"))
				editor.pinchar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			else if (line[0].equals("mover"))
				editor.mover(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			else if (line[0].equals("soltar"))
				editor.soltar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			else if (line[0].equals("dibujar"))
				editor.dibujar();
			else
				System.out.println("Comando no válido");

		} while (true);
	}

	private Editor editor;
	private BufferedReader in;

	private Tool circulo, cuadrado, triangulo;
}
