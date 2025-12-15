package behavorial.memento;

public class TextEditor {
	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	//new snapshot is being created
	public Memento save(){
		return new Memento(text);
	}
	public void restore(Memento memento){
		this.text = memento.getText();
	}

}
