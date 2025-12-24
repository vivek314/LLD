package interview.TextEditor.memento;

public class Memento {
    private final String text;

    protected Memento(String text) {
        this.text = text;
    }

    protected String getText() {
        return text;
    }
}