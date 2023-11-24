package creative_patterns.prototype;

import creative_patterns.prototype.shapes.Circle;
import creative_patterns.prototype.shapes.Rectangle;
import creative_patterns.prototype.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/*
Тип паттерна: порождающий.
Шаги создания:
1. Создайте интерфейс прототипов с единственным методом clone. Если у вас уже есть иерархия продуктов, метод
   клонирования можно объявить непосредственно в каждом из её классов.
2. Добавьте в классы будущих прототипов альтернативный конструктор, принимающий в качестве аргумента
   объект текущего класса. Этот конструктор должен скопировать из поданного объекта значения всех полей,
   объявленных в рамках текущего класса, а затем передать выполнение родительскому
   конструктору, чтобы тот позаботился о полях, объявленных в суперклассе.
3. Метод клонирования обычно состоит всего из одной строки: вызова оператора new с конструктором прототипа.
   Все классы, поддерживающие клонирование, должны явно определить метод clone, чтобы использовать собственный класс
   с оператором new. В обратном случае результатом клонирования станет объект родительского класса.
4. Опционально, создайте центральное хранилище прототипов. В нём удобно хранить вариации объектов,
   возможно, даже одного класса, но по-разному настроенных.
5. Вы можете разместить это хранилище либо в новом фабричном классе, либо в фабричном методе базового класса
   прототипов. Такой фабричный метод должен на основании входящих аргументов искать в хранилище прототипов
   подходящий экземпляр, а затем вызывать его метод клонирования и возвращать полученный объект.
6. Наконец, нужно избавиться от прямых вызовов конструкторов объектов, заменив
   их вызовами фабричного метода хранилища прототипов.

Примеры:
java.lang.Runtime#getRuntime()
java.awt.Desktop#getDesktop()
java.lang.System#getSecurityManager()
 */
public class TestPrototype {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(20);
        circle.setRadius(15);
        circle.setColor("red");
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.copy();
        shapes.add(anotherCircle);

        if ((anotherCircle != circle) && (anotherCircle.equals(circle))) {
            System.out.println("Прототип работает");
        }

        ColouredShapeCache cache = new ColouredShapeCache();

        Shape shape1 = cache.get("Big green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Большой зеленый круг != Средний синий прямоугольник (+)");
        } else {
            System.out.println("Большой зеленый круг == Средний синий прямоугольник  (-)");
        }

        if (shape2 != shape3) {
            System.out.println("Средние синие прямоугольники являются двумя разными объектами (+)");
            if (shape2.equals(shape3)) {
                System.out.println("Но они равны по equals (+)");
            } else {
                System.out.println("Но они не равны по equals (-)");
            }
        } else {
            System.out.println("Средние синие прямоугольники являются одним объектом (-)");
        }

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        rectangle.setColor("blue");
        shapes.add(rectangle);

        Shape.cloneAndCompare(shapes, shapesCopy);
        System.out.println();

        String plus = """
                1. Позволяет клонировать объекты не привязываясь к конкретным классам.
                2. Меньше повторяющегося кода инициализации объектов
                3. Ускоряет создание объектов.
                4. Альтернатива созданию подклассов для создания сложных объектов.
                """;

        String minus = """
                1. Сложно клонировать составные объекты, имеющие ссылки на другие объекты.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
