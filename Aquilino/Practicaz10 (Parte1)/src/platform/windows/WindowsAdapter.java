package platform.windows;

import java.awt.Point;

import platform.Image2D;
import platform.PlatformAdapter;

public class WindowsAdapter implements PlatformAdapter {

	private WindowsAPI windows;

	public WindowsAdapter() {
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
