package behavioral_patterns.command.commands;

import behavioral_patterns.command.editor.Editor;

public class CopyCommand extends Command{

    // В данном случае объект-получатель Editor передаётся в конструктор класса-команды
    public CopyCommand(Editor editor) {
        super(editor);
    }
    // Методы execute во всех командах исполняются через методы объекта-получателя.
    @Override
    public boolean execute() {
        editor.setClipboard(editor.getTextField().getSelectedText());
        return false;
    }
}
