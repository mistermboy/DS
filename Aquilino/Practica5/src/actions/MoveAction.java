package actions;

import editor.Figura;

public class MoveAction implements Action 
{
	private Figura figura;
	private int dx, dy;
	
	public MoveAction(Figura figura, int dx, int dy)
	{
		if (figura == null)
			throw new IllegalArgumentException("¡Se necesita la figura que ha sido movida!");
		this.figura = figura;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public void execute() 
	{
		figura.mover(dx, dy);		
	}

	@Override
	public void undo() 
	{
		figura.mover(-dx, -dy);
	}
	
	@Override
	public String toString()
	{
		return String.format("Mover la figura %s %d píxeles en horizontal y %d en vertical",
				figura, dx, dy);
	}
}
