package game;

import java.awt.Point;

import platform.Image2D;

public abstract class AbstractBallGame {

	public void play() {

		Image2D image = loadImage("Bola.jpg");

		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			drawBall(image, point);
		}
	}

	public abstract Image2D loadImage(String file);

	public abstract void drawBall(Image2D image, Point point);

	public abstract Point getPosition();

}
