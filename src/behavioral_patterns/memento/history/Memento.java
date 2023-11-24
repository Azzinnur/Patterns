package behavioral_patterns.memento.history;

import behavioral_patterns.memento.editor.MemEditor;

// Класс-компонент снимка. Внутри него хранится закодированное сотояния картинки и класс-создатель снимка.
public class Memento {
    private String backup;
    private MemEditor editor;

    public  Memento(MemEditor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
