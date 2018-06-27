package editor.figures;

import editor.*;
import editor.actions.CreateFigureAction;
import editor.tools.*;

// v1.3: Modificado para crear el triángulo a partir de tres puntos en vez de
//       mediante una selección rectangular; de ese modo se ve mejor cómo las
//       herramientas pueden implementar directamente la interfaz para proporcionar
//       comportamientos muy diferentes e imposibles de prever a priori.
//
public class TriangleCreationTool implements Tool 
{	
	private Editor editor;
	// las coordenadas X e Y de los tres vértices del triángulo
	private int x1, y1, x2, y2, x3, y3; 
	private int vertices; // número de puntos creados
	
	public TriangleCreationTool(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("Se necesita una referencia al editor");
		this.editor = editor;		
	}

	@Override
	public void clickOn(int x, int y) 
	{
		vertices++;
		if (vertices == 1) {
			editor.getDrawing().clearCurrentSelection();
			x1 = x;
			y1 = y;
		} else if (vertices == 2) {
			x2 = x;
			y2 = y;
		} else if (vertices == 3) {
			x3 = x;
			y3 = y;
			editor.getActionManager().executeAction(new CreateFigureAction(new Triangle(x1, y1, x2, y2, x3, y3), editor.getDrawing()));
			vertices = 0;
			editor.toolDone();
		}
	}

	@Override
	public void moveTo(int x, int y) 
	{
	}

	@Override
	public void release() 
	{
	}

	@Override
	public String toString()
	{
		return "Triángulo (herramienta de creación de)";
	}
}
