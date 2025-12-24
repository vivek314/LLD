package interview.TextEditor;

import interview.TextEditor.memento.MementoService;

public class TextEditorService {
    private String text;
    private final MementoService mementoService;

    public TextEditorService() {
        this.text = "";
        this.mementoService = new MementoService();
    }

    public void addText(String text) {
        this.text += text;
    }

    public void printText() {
        System.out.println(text);
        return;
    }

    public void save() {
        mementoService.saveMemento(this.text);
    }

    public void undo() {
        this.text = mementoService.undo(this.text);
    }

    public void redo() {
        this.text = mementoService.redo(this.text);
    }
}