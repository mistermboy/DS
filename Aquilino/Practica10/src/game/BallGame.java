package game;

import java.awt.Point;

import platform.*;
import platform.android.*;
import platform.playstation.*;
import platform.windows.*;

/* Esta clase/paquete ser�a el c�digo del videojuego, el cual se quiere reutilizar
 * en las distintas plataformas 
 */

enum Platform {
	ANDROID, WINDOWS, PLAYSTATION
};

public class BallGame {
	// Seleccionar para qu� plataforma se quiere generar el juego
	private Platform platform = Platform.ANDROID;
	// private Platform platform = Platform.WINDOWS;
	// private Platform platform = Platform.PLAYSTATION;

	private AndroidAPI android;
	private WindowsAPI windows;
	private Playstation5API playstation;

	private void setAPI() {
		if (platform == Platform.ANDROID)
			android = new AndroidAPI();
		else if (platform == Platform.WINDOWS)
			windows = new WindowsAPI();
		else
			playstation = new Playstation5API();
	}

	public void play() {
		setAPI();

		Image2D image = loadImage("Bola.jpg");

		// L�gica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			// Comprobar colisiones...
			// Imprimir marcador...
			// Otra l�gica del juego...
			drawBall(image, point);
		}
	}

	private Image2D loadImage(String file) {
		Image2D image;
		if (platform == Platform.ANDROID)
			image = android.loadResource(file);
		else if (platform == Platform.WINDOWS)
			image = windows.loadFile(file);
		else
			image = playstation.loadGraphics(file);
		return image;
	}

	private void drawBall(Image2D image, Point point) {
		if (platform == Platform.ANDROID)
			android.draw(point.x, point.y, image);
		else if (platform == Platform.WINDOWS)
			windows.paint(point.x, point.y, image);
		else
			playstation.render(point.x, point.y, image);
	}

	private Point getPosition() {
		Point point;
		if (platform == Platform.ANDROID)
			point = android.getTouch();
		else if (platform == Platform.WINDOWS)
			point = windows.getMouseClick();
		else
			point = playstation.getJoystick();
		return point;
	}
}
