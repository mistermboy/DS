package platform.playstation;

import java.awt.Point;

import platform.*;

public class PlaystationAdapter implements PlatformAdapter {

	@Override
	public Image2D load(String name) {
		return playstation.loadGraphics(name);
	}

	@Override
	public void show(int x, int y, Image2D image) {
		playstation.render(x, y, image);
	}

	@Override
	public Point getPosition() {
		return playstation.getJoystick();
	}

	private Playstation5API playstation = new Playstation5API();
}
