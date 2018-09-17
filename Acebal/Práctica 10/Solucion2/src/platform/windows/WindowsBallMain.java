package platform.windows;

import game.BallGame;

public class WindowsBallMain {

	public static void main(String[] args) {

		BallGame game = new BallGame(new WindowsAdapter());

		game.play();

	}

}
