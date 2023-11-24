package behavioral_patterns.visitor.visitor;

import structure_patterns.composite.shapes.Circle;
import structure_patterns.composite.shapes.CompoundShape;
import structure_patterns.composite.shapes.Dot;
import structure_patterns.composite.shapes.Rectangle;

// Интерфейс посетителя, с методами посещения класса каждого типа.
public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundShape(CompoundShape compoundShape);
}
