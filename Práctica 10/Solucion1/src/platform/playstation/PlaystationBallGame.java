package platform.playstation;

import game.*;
import java.awt.Point;
import platform.*;

public class PlaystationBallGame extends AbstractBallGame {

	private Playstation5API playstation;

	protected PlaystationBallGame() {
		playstation = new Playstation5API();
	}

	@Override
	protected Image2D loadImage(String file) {
		return playstation.loadGraphics(file);
	}

	@Override
	protected Point getPosition() {
		return playstation.getJoystick();
	}

	@Override
	protected void drawBall(Image2D image, Point point) {
		playstation.render(point.x, point.y, image);
	}

}
