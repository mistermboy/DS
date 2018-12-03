package main;

import java.io.IOException;

import editor.Editor;
import editor.ui.EditorUI;

public class Main {

	public static void main(String[] args) throws IOException {

		new EditorUI().showInfo();
		Editor editor = new Editor();

		editor.interprete();

	}

}
