package behavioral_patterns.memento.commands;

import behavioral_patterns.memento.editor.MemEditor;
import behavioral_patterns.memento.shapes.MemShape;

import java.awt.*;


// Команда, отвечающая за изменение цвета
public class ColorCommand implements MemCommand {
    private MemEditor editor;
    private Color color;

    public ColorCommand(MemEditor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Смена цвета на: [r=" + color.getRed() + ", g=" + color.getGreen() + ", b=" + color.getBlue() + "]";
    }

    @Override
    public void execute() {
        for (MemShape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
