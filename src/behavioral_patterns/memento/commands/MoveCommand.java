package behavioral_patterns.memento.commands;

import behavioral_patterns.memento.editor.MemEditor;
import behavioral_patterns.memento.shapes.MemShape;

// Команда, отвечающая за перемещение фигуры
public class MoveCommand implements MemCommand{
    private MemEditor editor;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public MoveCommand(MemEditor editor) {
        this.editor = editor;
    }

    @Override
    public String getName() {
        return "Сдвиг по X на " + (endX - startX) + " и по Y на " + (endY - startY);
    }

    public void start(int x, int y) {
        startX = x;
        startY = y;
        for (MemShape child : editor.getShapes().getSelected()) {
            child.drag();
        }
    }

    public void move(int x, int y) {
        for (MemShape child : editor.getShapes().getSelected()) {
            child.moveTo(x - startX, y - startY);
        }
    }

    public void stop(int x, int y) {
        endX = x;
        endY = y;
        for (MemShape child : editor.getShapes().getSelected()) {
            child.drop();
        }
    }

    @Override
    public void execute() {
        for (MemShape child : editor.getShapes().getSelected()) {
            child.moveBy(endX - startX, endY - startY);
        }
    }
}
