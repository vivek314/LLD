package interview.TextEditor.memento;

import java.util.Stack;

import interview.TextEditor.Constants;

public class MementoService {
    private final Stack<Memento> undoMemento;
    private final Stack<Memento> redoMemento;

    public MementoService() {
        this.undoMemento = new Stack<>();
        this.redoMemento = new Stack<>();
    }

    public void saveMemento(String text) {
        undoMemento.push(new Memento(text));
    }

    public boolean canAdd() {
        return undoMemento.size() < Constants.MAX_UNDO_REDO;
    }

    public String undo(String text) {
        if (undoMemento.isEmpty()) {
            System.out.println("Nothing to undo!");
            return "";
        }
        Memento memento = undoMemento.pop();
        redoMemento.push(new Memento(text));
        return memento.getText();
    }

    public String redo(String text) {
        if (redoMemento.isEmpty()) {
            System.out.println("Nothing to redo!");
            return "";
        }
        Memento memento = redoMemento.pop();
        undoMemento.push(new Memento(text));
        return memento.getText();
    }
}
