package editor.actions;

import java.io.IOException;

import editor.Editor;

public class Insert implements Action {

	private String[] line;

	public Insert(String[] line) {
		this.line = line;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		for (int i = 1; i < line.length; i++) {
			editor.getTexto().append(line[i] + " ");
		}
	}

}
