package behavioral_patterns.visitor.shapes;

import behavioral_patterns.visitor.visitor.Visitor;
import structure_patterns.composite.shapes.Shape;

// Интерфейс, интегрирующий в классы фигур концепцию паттерна Посетитель с единственным абстрактным методом.
// Все реализации данного интерфейса находятся в structure_patterns.composite.shapes.
public interface VisShape extends Shape {
    String accept(Visitor visitor);
}
