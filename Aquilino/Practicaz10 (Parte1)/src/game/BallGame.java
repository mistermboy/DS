package game;

import java.awt.Point;

import platform.Image2D;
import platform.PlatformAdapter;

public class BallGame {

	public void play(PlatformAdapter platform) {

		Image2D image = platform.loadImage("Bola.jpg");

		for (int i = 0; i < 10; i++) {
			Point point = platform.getPosition();
			platform.drawBall(image, point);
		}
	}

}
