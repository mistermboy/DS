package editor.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import editor.Editor;

public class Macro implements Action {

	private String name;
	private List<Action> actions = new ArrayList<>();

	public Macro(String name) {
		this.name = name;
	}

	public void addAction(Action action) {
		actions.add(action);
	}

	@Override
	public void execute(Editor editor) throws IOException {
		for(Action a:actions)
			a.execute(editor);
	}

	public String getName() {
		return name;
	}
	
	

}
