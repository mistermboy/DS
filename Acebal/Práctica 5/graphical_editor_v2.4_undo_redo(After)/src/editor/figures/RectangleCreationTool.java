package editor.figures;

import editor.*;
import editor.tools.*;

public class RectangleCreationTool extends AbstractCreationTool implements Tool 
{	
	public RectangleCreationTool(Editor editor)
	{
		super(editor);
	}
	
	@Override
	protected Figure createFigure(BoundingBox boundingBox) 
	{
		return new Rectangle(boundingBox);
	}

	@Override
	public String toString()
	{
		return "Rectángulo (herramienta de creación de)";
	}
}
