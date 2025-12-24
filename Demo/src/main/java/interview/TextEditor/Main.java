package interview.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditorService textEditorService = new TextEditorService();
        textEditorService.addText("Hello");
        textEditorService.printText();
        textEditorService.save();
        textEditorService.addText(" World");
        textEditorService.printText();
        textEditorService.undo();
        textEditorService.printText();
        textEditorService.redo();
        textEditorService.printText();
    }
}