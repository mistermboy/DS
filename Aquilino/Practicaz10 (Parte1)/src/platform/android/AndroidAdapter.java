package platform.android;

import java.awt.Point;

import platform.Image2D;
import platform.PlatformAdapter;

public class AndroidAdapter implements PlatformAdapter {

	private AndroidAPI android;

	public AndroidAdapter() {
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
