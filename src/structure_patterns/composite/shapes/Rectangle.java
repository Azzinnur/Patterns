package structure_patterns.composite.shapes;

import behavioral_patterns.visitor.visitor.Visitor;

import java.awt.*;

// Один из классов-листьев дерева
public class Rectangle extends BaseShape{
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(x, y, getWidth() - 1, getHeight() - 1);
    }

    // Дополнительная логика, необходимая для паттерна Посетитель.
    public Rectangle(int id, int x, int y, int width, int height, Color color) {
        super(id, x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }

}
