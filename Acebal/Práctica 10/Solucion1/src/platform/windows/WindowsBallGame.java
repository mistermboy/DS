package platform.windows;

import game.*;

import java.awt.Point;

import platform.*;

public class WindowsBallGame extends AbstractBallGame {
	private WindowsAPI windows;

	protected WindowsBallGame() {
		windows = new WindowsAPI();
	}

	@Override
	protected Image2D loadImage(String file) {
		return windows.loadFile(file);
	}

	@Override
	protected Point getPosition() {
		return windows.getMouseClick();
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		windows.paint(point.x, point.y, image);
	}

}
