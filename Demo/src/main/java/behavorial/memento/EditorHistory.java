package behavorial.memento;

import java.util.Stack;

public class EditorHistory {
	Stack<Memento> history = new Stack<Memento>();
	Stack<Memento> redoStack = new Stack<>();

	public void saveState(Memento memento){
		history.push(memento);
		redoStack.clear();
	}

	public Memento undo(Memento memento){
		if(!history.isEmpty()){
			redoStack.push(memento);
			return history.pop();
		}
		return null;
	}

	public Memento redo(Memento memento){
		if(!redoStack.isEmpty()){
			history.push(memento);
			return redoStack.pop();
		}
		return null;
	}
}
