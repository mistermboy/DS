package editor;

import java.io.IOException;
import java.util.HashMap;

import editor.actions.Action;
import editor.actions.Macro;

public class ActionManager {

	private Editor editor;

	private HashMap<String, Macro> macros = new HashMap<>();
	private Macro macro;
	private boolean recording = false;

	public ActionManager(Editor editor) {
		this.editor = editor;
	}

	public void execute(Action action) throws IOException {
		if (recording)
			macro.addAction(action);
		else
			action.execute(editor);
	}

	public void executeMacro(String macro) throws IOException {
		execute(macros.get(macro));
	}

	public void record(String macro) {
		this.macro = new Macro(macro);
		recording = true;
	}

	public void stop() {
		macros.put(macro.getName(), macro);
		recording = false;
	}

}
