package editor.tools;

import editor.*;
import editor.actions.CreateFigureAction;

public abstract class AbstractCreationTool implements Tool
{
	/*
	 * Una referencia al editor. Es necesaria para poder añadir la nueva figura, una
	 * vez creada, al documento de dibujo. ¿Por qué no hacer que las herramientas de
	 * creación se limiten a devolver la nueva figura creada, a través del método
	 * release(), y que sea el propio editor quien, a través del valor de retorno de
	 * dicho método, añada la figura devuelta? De esa forma no haría falta que las
	 * herramientas (al menos las de creación) tuviesen dicha referencia al editor.
	 * La respuesta es que no es posible porque la operación concreta a realizar
	 * cuando se suelta el botón del ratón depende de cada tipo de herramienta. Sí
	 * es común a todas las de creación, pero para la de selección (u otras que
	 * pudiera haber en un futuro) no tendría sentido que la signatura de dicho
	 * método especificase que se devolviese una figura (y, aunque así fuese, 
	 * entonces el editor tendría que saber qué tipo concreto de herramienta era
	 * para saber qué tenía que hacer ante dicho evento). De esta forma logramos
	 * (que es lo importante) que el editor sea agnóstico respecto del tipo de
	 * herramienta seleccionada: son éstas las que saben qué tienen que hacer en cada
	 * caso ante los eventos que provienen del editor: hacer clic, mover, soltar...
	 */
	private Editor editor;

	private BoundingBox boundingBox;

	protected AbstractCreationTool(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("Las herramientas de creación necesitan una referencia (no nula) al editor");
		this.editor = editor;
		
	}

	@Override
	public void clickOn(int x, int y) 
	{
		editor.trace(String.format("Comenzando a crear un área rectangular en (%d, %d)...", x, y));
		// añadido para limpiar la selección actual, si la hubiere
		editor.getDrawing().clearCurrentSelection();
		boundingBox = new BoundingBox(x, y);
	}

	@Override
	public void moveTo(int x, int y) 
	{
		if (boundingBox == null) {
			editor.trace(String.format("Se movió el cursor a (%d, %d), pero sin haber pulsado antes: no tiene ningún efecto", x, y));
			return;
		}
		editor.trace(String.format("Se movió el cursor del ratón a la posición (%d, %d)", x, y));
		boundingBox.resizeTo(x, y);
		editor.trace("El área actual de la herramienta de creación es: " + boundingBox);
	}

	@Override
	public void release() 
	{
		if (boundingBox == null)
			throw new IllegalStateException("No tiene sentido recibir un evento de soltar sin haber pulsado antes");
		Figure newFigure = createFigure(boundingBox);
		editor.getActionManager().executeAction(new CreateFigureAction(newFigure, editor.getDrawing()));
		editor.trace("Se creó la figura: " + newFigure);		
		editor.toolDone();
		boundingBox = null; // al soltar se elimina el área actual
	}
	
	protected abstract Figure createFigure(BoundingBox boundingBox);
	
	@Override
	public String toString()
	{
		return "Herramienta (abstracta) de creación";
	}
}
