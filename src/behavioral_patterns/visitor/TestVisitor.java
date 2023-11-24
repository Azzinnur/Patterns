package behavioral_patterns.visitor;

import behavioral_patterns.visitor.visitor.XMLExportVisitor;
import structure_patterns.composite.shapes.Circle;
import structure_patterns.composite.shapes.CompoundShape;
import structure_patterns.composite.shapes.Dot;
import structure_patterns.composite.shapes.Rectangle;

import java.awt.*;
/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Создайте интерфейс посетителя и объявите в нём методы «посещения» для каждого класса элемента,
   который существует в программе.
2. Опишите интерфейс элементов. Если вы работаете с уже существующими классами, то объявите абстрактный метод
   принятия посетителей в базовом классе иерархии элементов.
3. Реализуйте методы принятия во всех конкретных элементах. Они должны переадресовывать вызовы тому методу
   посетителя, в котором тип параметра совпадает с текущим классом элемента.
4. Иерархия элементов должна знать только о базовом интерфейсе посетителей. С другой стороны, посетители будут
   знать обо всех классах элементов.
5. Для каждого нового поведения создайте конкретный класс посетителя. Приспособьте это поведение для работы со всеми
   типами элементов, реализовав все методы интерфейса посетителей.
6. Вы можете столкнуться с ситуацией, когда посетителю нужен будет доступ к приватным полям элементов. В этом случае
   вы можете либо раскрыть доступ к этим полям, нарушив инкапсуляцию элементов, либо сделать класс посетителя вложенным
   в класс элемента.
7. Клиент будет создавать объекты посетителей, а затем передавать их элементам, используя метод принятия.

Примеры:
javax.lang.model.element.AnnotationValue и AnnotationValueVisitor
javax.lang.model.element.Element и ElementVisitor
javax.lang.model.type.TypeMirror и TypeVisitor
java.nio.file.FileVisitor и SimpleFileVisitor
javax.faces.component.visit.VisitContext и VisitCallback
 */
public class TestVisitor {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55, Color.RED);
        Circle circle = new Circle(2, 23, 15, 10, Color.YELLOW);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30, Color.PINK);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot, circle, rectangle);

        CompoundShape anotherCompoundShape = new CompoundShape(5);
        anotherCompoundShape.add(circle);
        compoundShape.add(anotherCompoundShape);

        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(compoundShape));
        System.out.println();

        String plus = """
                1. Упрощает добавление операций, работающих со сложными структурами объектов.
                2. Объединяет родственные операции в одном классе.
                3. Посетитель может накапливать состояние при обходе структуры элементов.
                """;

        String minus = """
                1. Паттерн не оправдан, если иерархия элементов часто меняется.
                2. Может привести к нарушению инкапсуляции элементов.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
