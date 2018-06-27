package editor.ui;

import java.io.*;

import editor.Editor;
import editor.figures.*;
import editor.tools.*;

public class Console 
{
	private Editor editor;
	private BufferedReader input;
	private PrintWriter output;
	private boolean exit = false;
	
	private Tool selectionTool, rectangle, circle, triangle;
	
	public Console(Editor editor)
	{
		this(editor, System.in, System.out);		
	}
	
	public Console(Editor editor, InputStream input, PrintStream output)
	{
		this(editor, new InputStreamReader(input), new PrintWriter(output, true));
	}
	
	public Console(Editor editor, Reader input, Writer output)
	{
		this.input = new BufferedReader(input);
		this.output = new PrintWriter(output, true);
		this.editor = editor;
		selectionTool = new SelectionTool(editor);
		rectangle = new RectangleCreationTool(editor);	
		circle = new CircleCreationTool(editor);
		triangle = new TriangleCreationTool(editor);
	}
	
	public void run() throws IOException
	{
		showHelp();
		while (!exit) {
			try {
				askUser();				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		output.println("¡Adios!");
		return;
	}
	
	private void showHelp()
	{
		output.println("");
		output.println("Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println("Acciones del ratón: pulsar <x>,<y> - mover <x>,<y> - soltar");
		output.println("Otras acciones: dibujar - deshacer - repetir - ayuda - salir");
		output.println("------------------------------------------------------------");
	}
	
	private void askUser() throws IOException
	{
		output.print("> ");
		output.flush();
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];
		
		// Comprueba que a las acciones que no requieren parámetros, efectivamente no se les
		// pase ninguno (por usabilidad, para que el usuario se dé cuenta de que la última 
		// acción no funciona como él esperaba). Por ejemplo, si por equivocación tecleó:
		//
		// 		"soltar 200, 345"
		//
		// cuando realmente esas coordenadas no son tenidas en cuenta (se debería haber
		// llamado previamente a "mover 200, 345" y luego simplemente "soltar").
		//
		if (action.equals("seleccion") || action.equals("rectangulo") ||
				action.equals("circulo") || action.equals("triangulo") ||
				action.equals("soltar") || action.equals("dibujar") ||
				action.equals("deshacer") || action.equals("repetir") ||
				action.equals("ayuda") || action.equals("salir")) {
			if (tokens.length > 1) {
				output.printf("Error de sintaxis: \"%s\" no tiene parámetros\n", action);
				return;
			}
		}
		
		if (action.equals("salir")) {
			exit = true;
		} else if (action.equals("seleccion")) {
			editor.selectTool(selectionTool);
		} else if (action.equals("rectangulo")) {
			editor.selectTool(rectangle);
		} else if (action.equals("circulo")) {
			editor.selectTool(circle);
		} else if (action.equals("triangulo")) {
			// Con el cambio hecho en la herramienta de creación de triángulos podría
			// ocurrir que el usuario, con ella seleccionada, pulsase un par de puntos
			// y luego cancelase la operación seleccionando otra herramienta; en ese
			// caso al volver a seleccionar posteriormente la herramienta de creación de
			// triángulos, si usamos siempre, sin más, el mismo objeto, habrían quedado
			// guardados los dos puntos anteriores, que no es correcto. Ahora mismo, como
			// apaño, se crea un objeto nuevo cada vez; una solución mejor habría sido,
			// posiblemente, proporcionar un nuevo método a todas las herramientas para
			// notificar cada vez que se activaban (y que cada una hiciera lo que tuviese
			// que hacer en cada caso).
			triangle = new TriangleCreationTool(editor);			
			editor.selectTool(triangle);
		} else if (action.equals("pulsar")) {
			try {
				// la siguiente línea es para que funcione independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				editor.clickedOn(x, y);
			} catch (NumberFormatException e) {
				output.println("Error de sintaxis: se esperaban las coordenadas del punto en que se hizo clic: pulsar <x>, <y>");
			}
		} else if (action.equals("mover")) {
			try {
				// la siguiente línea es para que funcione independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				editor.movedTo(x, y);
			} catch (NumberFormatException e) {
				output.println("Error de sintaxis: se esperaban las coordenadas del punto adonde se movió el cursor: mover <x>, <y>");
			}
		} else if (action.equals("soltar")) {
			editor.released();
		} else if (action.equals("dibujar")) {
			editor.drawDocument();
		} else if (action.equals("deshacer")) {
			if (!editor.getActionManager().canBeUndone()) {
				output.println("No hay nada que deshacer");
				return;
			}
			editor.undo();
		} else if (action.equals("repetir")) {
			if (!editor.getActionManager().canBeRedone()) {
				output.println("No hay nada que repetir");
				return;
			}
			editor.redo();
		} else if (action.equals("ayuda")) {
			showHelp();
		} else {
			output.println("Acción desconocida");
			showHelp();
		}
	}
}
