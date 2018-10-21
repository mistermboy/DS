package actions;

import java.util.Stack;

public class ActionManager {

	private Stack<Action> undoableActions = new Stack<>();
	private Stack<Action> redoableActions = new Stack<>();

	public void executeAction(Action action) {
		clear();
		action.execute();
		undoableActions.push(action);
	}

	private void clear() {
		redoableActions.clear();
	}

	public void addUndoableAction(Action action) {
		clear();
		undoableActions.push(action);
	}

	public boolean canBeUndone() {
		return !undoableActions.isEmpty();
	}

	public void undo() {
		if (!canBeUndone())
			throw new IllegalStateException("No hay acciones que deshacer");
		Action action = undoableActions.pop();
		action.undo();
		redoableActions.push(action);
	}

	public void redo() {
		if (!canBeRedone())
			throw new IllegalStateException("No hay ninguna operación que repetir");
		Action action = redoableActions.pop();
		action.execute();
		undoableActions.push(action);
	}
	
	public boolean canBeRedone() {
		return !redoableActions.isEmpty();
	}
}
