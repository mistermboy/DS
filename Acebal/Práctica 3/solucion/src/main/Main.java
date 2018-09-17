package main;
import java.io.*;

import editor.*;


public class Main {

	public static void main(String[] args) throws IOException {
		Editor editor = new Editor(new Dibujo());
		TextModeInterface userInterface = new TextModeInterface(new InputStreamReader(System.in), editor);
		userInterface.run();
	}

}
