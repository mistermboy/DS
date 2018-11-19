package game;

import platform.android.AndroidAdapter;
import platform.playstation.PlaystationAdapter;
import platform.windows.WindowsAdapter;

public class Main {
	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.play(new AndroidAdapter());
		game.play(new PlaystationAdapter());
		game.play(new WindowsAdapter());

	}
}
