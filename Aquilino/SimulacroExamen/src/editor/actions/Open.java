package editor.actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import editor.Editor;

public class Open implements Action {

	private String file;

	public Open(String file) {
		this.file = file;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		editor.setTexto(readFile(file));

	}

	private StringBuilder readFile(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}

}
