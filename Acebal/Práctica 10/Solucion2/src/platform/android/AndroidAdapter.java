package platform.android;

import java.awt.Point;

import platform.*;


public class AndroidAdapter implements PlatformAdapter {

	@Override
	public Image2D load(String name) {
		return android.loadResource(name);
	}

	@Override
	public void show(int x, int y, Image2D image) {
		android.draw(x, y, image);
	}

	@Override
	public Point getPosition() {
		return android.getTouch();
	}

	private AndroidAPI android = new AndroidAPI();
}
