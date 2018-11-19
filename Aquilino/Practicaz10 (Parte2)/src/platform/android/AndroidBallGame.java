package platform.android;

import java.awt.Point;

import game.AbstractBallGame;
import platform.Image2D;

public class AndroidBallGame extends AbstractBallGame {

	private AndroidAPI android;

	public AndroidBallGame() {
		this.android = new AndroidAPI();
	}

	@Override
	public Image2D loadImage(String source) {
		return android.loadResource(source);
	}

	@Override
	public Point getPosition() {
		return android.getTouch();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		android.draw((int) point.getX(), (int) point.getY(), image);
	}

}
