package platform;

import java.awt.Point;

public interface PlatformAdapter {
	Image2D load(String name);

	void show(int x, int y, Image2D image);

	Point getPosition();
}
