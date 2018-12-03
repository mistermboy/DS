package editor.actions;

import java.io.IOException;
import java.util.regex.Pattern;

import editor.Editor;

public class Replace implements Action {

	private String line1;
	private String line2;

	public Replace(String line1, String line2) {
		this.line1 = line1;
		this.line2 = line2;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		editor.setTexto(new StringBuilder(editor.getTexto().toString().replaceAll(Pattern.quote(line1), line2)));
	}

}
