package CH.ifa.draw.samples.nada;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import CH.ifa.draw.standard.AbstractFigure;

public class EjemploFigure extends AbstractFigure {

	public EjemploFigure() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(origin.x,origin.y, corner.x,corner.y);
	}

	@Override
	protected void basicMoveBy(int dx, int dy) {
		this.origin.setLocation(origin.x+dx,origin.y+dy);	
	}

	@Override
	public void basicDisplayBox(Point origin, Point corner) {
		this.origin = origin;
		this.corner = corner;
	}

	@Override
	public Rectangle displayBox() {
		return new Rectangle(origin.x,origin.y, corner.x,corner.y);
	}

	@Override
	public Vector handles() {
		return new Vector();
	}

	private Point origin,corner;
	
}
