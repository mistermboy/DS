package editor.actions;

import java.io.IOException;

import editor.Editor;

public class Delete implements Action {

	@Override
	public void execute(Editor editor) throws IOException {
		int indexOfLastWord = editor.getTexto().toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			editor.setTexto(new StringBuilder(""));
		else
			editor.getTexto().setLength(indexOfLastWord + 1);
	}

}
