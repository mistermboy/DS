package actions;

import editor.Dibujo;
import editor.Figura;


public class CreateFigureAction implements Action
{
	private Dibujo dibujo;
	private Figura figura;
	private Figura previousSelection;
	
	public CreateFigureAction(Figura figure, Dibujo dibujo)
	{
		this.figura = figure;
		this.dibujo = dibujo;
	}


	@Override
	public void execute() 
	{
		previousSelection = dibujo.getCurrentSelection();
		dibujo.AddFigura(figura);
	}

	/**
	 * Deshace el resultado de una ejecución previa de esta acción, eliminando
	 * la figura añadida anteriormente. Así mismo, deja la selección actual del
	 * documento en el estado previo a la adición de dicha figura.
	 */
	@Override
	public void undo() 
	{
		dibujo.removeFigure(figura);
		if (previousSelection == null)
			dibujo.clearCurrentSelection();
		else
			dibujo.setCurrentSelection(previousSelection);
	}
	
	@Override
	public String toString()
	{
		return "Añadir figura: " + figura;
	}
}
