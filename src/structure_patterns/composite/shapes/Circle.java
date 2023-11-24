package structure_patterns.composite.shapes;

import behavioral_patterns.visitor.visitor.Visitor;

import java.awt.*;

// Один из классов-листьев дерева
public class Circle extends BaseShape {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }

    // Дополнительная логика, необходимая для паттерна Посетитель.
    public Circle(int id, int x, int y, int radius, Color color) {
        super(id, x, y, color);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}

