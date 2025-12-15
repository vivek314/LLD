package behavorial.memento;

public class Main {
	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		EditorHistory history = new EditorHistory();
		te.setText("Hello World");
		System.out.println("Current text: " + te.getText());
		history.saveState(te.save());
		te.setText("HI Robot");
		System.out.println("Current text: " + te.getText());
		te.restore(history.undo(te.save()));
		System.out.println("Undoed text: " + te.getText());
		te.restore(history.redo(te.save()));
		System.out.println("Redoed text: " + te.getText());
	}
}
