package behavioral_patterns.memento.shapes;

import structure_patterns.composite.shapes.Shape;

import java.awt.*;

// Основной интерфейс фигур. Все классы имплементирующие интерфейс находятся в structure_patterns.composite.shapes
public interface MemShape extends Shape {
    void drag();

    void drop();

    void moveTo(int x, int y);

    Color getColor();

    void setColor(Color color);
}
