package platform;

import java.awt.Point;

public interface PlatformAdapter {

	Image2D loadImage(String source);

	Point getPosition();

	void drawBall(Image2D image, Point point);

}
