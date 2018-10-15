package main;

import java.io.IOException;

import editor.Dibujo;
import editor.Editor;

public class Main {

	public static void main(String[] args) throws IOException {

		Editor editor = new Editor(new Dibujo());

		TextInterface userInterface = new TextInterface(editor);
		userInterface.run();
	}

}
