package editor;

import java.io.IOException;

import editor.ui.Console;

public class Application 
{
	public static void main(String[] args) throws IOException
	{
		Editor editor = new Editor();
		Console console = new Console(editor);
		console.run();
	}
}
