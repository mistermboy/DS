package figures;

import java.awt.Point;

public interface Figure {

	void draw();

	void pinchar(Point point);

	void soltar(int x, int y);
	
	boolean esPinchada(int x,int y);

}
