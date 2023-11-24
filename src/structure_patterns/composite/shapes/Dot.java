package structure_patterns.composite.shapes;

import behavioral_patterns.visitor.visitor.Visitor;

import java.awt.*;

// Один из классов-листьев дерева
public class Dot extends BaseShape{
    private static final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() { return DOT_SIZE; }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
    }

    // Дополнительная логика, необходимая для паттерна Посетитель
    @Override
    public String accept(Visitor visitor) {
        return visitor.visitDot(this);
    }

    public Dot(int id, int x, int y, Color color) {
        super(id, x, y, color);
    }

}
