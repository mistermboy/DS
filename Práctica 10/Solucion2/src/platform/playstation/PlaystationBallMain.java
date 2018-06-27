package platform.playstation;

import game.BallGame;

public class PlaystationBallMain {

	public static void main(String[] args) {

		BallGame game = new BallGame(new PlaystationAdapter());

		game.play();

	}

}
