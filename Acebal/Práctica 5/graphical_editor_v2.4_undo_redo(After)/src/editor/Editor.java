package editor;

import java.io.*;

import editor.actions.ActionManager;
import editor.tools.*;

public class Editor 
{
	/**
	 * Representa el documento de dibujo. Actualmente se considera que el editor sólo
	 * tiene un único documento abierto en cada momento, pero cambiar esto sería trivial.
	 */
	private Drawing drawing = new Drawing();
	
	private PrintWriter output = new PrintWriter(System.out, true);
	
	public static boolean DEBUG = false;
	
	/**
	 * La herramienta predeterminada, que en nuestro caso es la de selección.
	 */
	private Tool selectionTool;
	
	/**
	 * La herramienta seleccionada actualmente en el editor. Dependiendo de
	 * cuál sea ésta, el editor responderá de manera diferente ante los eventos
	 * del ratón que le llegan de la interfaz de usuario. Para ello simplemente
	 * delegará en los métodos correspondientes de la herramienta actual.
	 */
	private Tool currentTool;
	
	public Editor()
	{
		currentTool = selectionTool = new SelectionTool(this);
	}
	
	/**
	 * Devuelve una referencia al documento de dibujo actual.
	 * 
	 * @return el documento de dibujo actual
	 */
	public Drawing getDrawing()
	{
		return drawing;
	}
	
	/**
	 * Cambia la herramienta actual.
	 * 
	 * @param tool la nueva herramienta seleccionada
	 */
	public void selectTool(Tool tool)
	{
		if (tool == null)
			throw new IllegalArgumentException("¡No se puede seleccionar una herramienta nula!");
		currentTool = tool;
		trace("Se seleccionó la herramienta: " + tool);
	}
	
	/**
	 * Las herramientas deben llamar a este método para avisar al editor que han
	 * terminado y que éste lleve a cabo las acciones oportunas. En esta versión
	 * esta operación simplemente consiste en, de acuerdo con los requisitos, volver
	 * a seleccionar la herramienta de selección como la que está activa actualmente.
	 * Es decir, todas las herramientas, cuando acaban, dejan de estar activas y el
	 * editor selecciona automáticamente de nuevo la herramienta predeterminada, que
	 * es la de selección.<p>
	 * 
	 * ¿Hace falta que las herramientas llamen a este método para eso? ¿No valdría
	 * con que lo hiciese el propio editor en el método {@code released}? No, porque
	 * puede haber herramientas (por ejemplo, la de creación de triángulos, si lo
	 * hiciésemos mediante tres puntos en vez de con un área rectangular, o una de
	 * creación de polígonos, etcétera) que requiriesen varias pulsaciones de ratón.
	 * Y si bien es cierto que las propias herramientas, dado que guardan una referencia
	 * al editor, podrían cambiar ellas mismas la herramienta actual mediante el método
	 * {@code setTool(Tool)}, esto implicaría que deberían conocerse entre ellas (mayor
	 * acoplamiento que de esta forma), junto con los problemas de duplicación de dicho
	 * comportamiento en varias clases, que futuras herramientas creadas por un usuario
	 * del framework tuvieran que saber (y acordarse) que tienen que realizar dicho
	 * cambio).
	 */
	public void toolDone()
	{
		selectTool(selectionTool);
	}
	
	/**
	 * Dibuja el documento actual.
	 */
	public void drawDocument()
	{
		output.println("Herramienta seleccionada: " + currentTool);
		drawing.draw(output);
	}		
	
	// Eventos del ratón
	
	public void clickedOn(int x, int y)
	{
		currentTool.clickOn(x, y);
	}
	
	public void movedTo(int x, int y)
	{
		currentTool.moveTo(x, y);
	}
	
	public void released()
	{
		currentTool.release();
	}
	
	// Operaciones que manejan las acciones del editor que se pueden deshacer/repetir
	
	public void undo()
	{
		getActionManager().undo();
	}
	
	public void redo()
	{
		getActionManager().redo();		
	}
	
	public ActionManager getActionManager()
	{
		return getDrawing().getActionManager();
	}
	
	// Sencilla utilidad de traza
	
	public void trace(String message)
	{
		if (DEBUG)
			output.println(message);
	}	
}
