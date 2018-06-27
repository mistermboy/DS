package editor.actions;

import editor.Drawing;
import editor.Figure;

/**
 * Representa la acción de añadir una nueva figura al documento de dibujo actual.
 */
public class CreateFigureAction implements Action
{
	private Drawing drawing;
	private Figure figure;
	private Figure previousSelection;
	
	public CreateFigureAction(Figure figure, Drawing drawing)
	{
		if (figure == null)
			throw new IllegalArgumentException("La acción de crear figura necesita la nueva figura a añadir al documento");
		if (drawing == null)
			throw new IllegalArgumentException("Se necesita una referencia no nula al documento de dibujo");
		this.figure = figure;
		this.drawing = drawing;
	}

	/**
	 * Añade una nueva figura al documento de dibujo (ambos especificados como
	 * parámetros en el constructor de esta acción). Además, cada vez que se
	 * crea una nueva figura se limpia la selección que hubiera anteriormente
	 * en el documento (si es que había algo seleccionado) y la nueva figura
	 * pasa a ser la selección actual de dicho documento.
	 */
	@Override
	public void execute() 
	{
		previousSelection = drawing.getCurrentSelection();
		drawing.addFigure(figure);
	}

	/**
	 * Deshace el resultado de una ejecución previa de esta acción, eliminando
	 * la figura añadida anteriormente. Así mismo, deja la selección actual del
	 * documento en el estado previo a la adición de dicha figura.
	 */
	@Override
	public void undo() 
	{
		drawing.removeFigure(figure);
		if (previousSelection == null)
			drawing.clearCurrentSelection();
		else
			drawing.setCurrentSelection(previousSelection);
	}
	
	@Override
	public String toString()
	{
		return "Añadir figura: " + figure;
	}
}
