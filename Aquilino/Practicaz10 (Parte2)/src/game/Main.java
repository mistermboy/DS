package game;

import platform.android.AndroidBallGame;
import platform.playstation.Playstation5BallGame;
import platform.windows.WindowsBallGame;

public class Main {
	public static void main(String[] args) {

		AbstractBallGame game = new AndroidBallGame();
		game.play();

		game = new Playstation5BallGame();
		game.play();

		game = new WindowsBallGame();
		game.play();

	}
}
