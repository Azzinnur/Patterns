package behavioral_patterns.command.commands;

import behavioral_patterns.command.editor.Editor;

//Общий интерфейс
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.getTextField().getText();
    }

    public void undo() {
        editor.getTextField().setText(backup);
    }

    //Метод запуска
    public abstract boolean execute();
}
