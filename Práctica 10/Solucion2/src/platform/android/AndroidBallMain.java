package platform.android;

import game.BallGame;

public class AndroidBallMain {

	public static void main(String[] args) {

		BallGame game = new BallGame(new AndroidAdapter());

		game.play();
	}

}
