package platform.windows;

import java.awt.Point;

import game.AbstractBallGame;
import platform.Image2D;

public class WindowsBallGame extends AbstractBallGame {

	private WindowsAPI windows;

	public WindowsBallGame() {
		this.windows = new WindowsAPI();
	}

	@Override
	public Image2D loadImage(String source) {
		return windows.loadFile(source);
	}

	@Override
	public Point getPosition() {
		return windows.getMouseClick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windows.paint((int) point.getX(), (int) point.getY(), image);
	}

}
