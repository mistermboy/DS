package platform.playstation;

import java.awt.Point;

import game.AbstractBallGame;
import platform.Image2D;

public class Playstation5BallGame extends AbstractBallGame {

	private Playstation5API play;

	public Playstation5BallGame() {
		this.play = new Playstation5API();
	}

	@Override
	public Image2D loadImage(String source) {
		return play.loadGraphics(source);
	}

	@Override
	public Point getPosition() {
		return play.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		play.render((int) point.getX(), (int) point.getY(), image);
	}

}
