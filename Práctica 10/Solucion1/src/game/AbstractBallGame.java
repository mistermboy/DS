package game;

import java.awt.Point;

import platform.Image2D;

// Código del juego que se quiere poder ejecutar en
// distintas plataformas sin tener que modificarlo

public abstract class AbstractBallGame {

	// Parte fija del algoritmo
	public void play() {

		Image2D image = loadImage("Bola.jpg");

		// Lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			// Comprobar colisiones...
			// Imprimir marcador...
			// Otra lógica del juego...
			drawBall(image, point);
		}
	}

	
	// Partes variables del algoritmo
	protected abstract Image2D loadImage(String file);
	protected abstract void drawBall(Image2D image, Point point);
	protected abstract Point getPosition();

}