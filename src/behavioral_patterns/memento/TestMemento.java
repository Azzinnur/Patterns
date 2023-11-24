package behavioral_patterns.memento;

import behavioral_patterns.memento.editor.MemEditor;
import structure_patterns.composite.shapes.Circle;
import structure_patterns.composite.shapes.CompoundShape;
import structure_patterns.composite.shapes.Dot;
import structure_patterns.composite.shapes.Rectangle;

import java.awt.*;
import java.lang.reflect.Field;

/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Определите класс создателя, объекты которого должны создавать снимки своего состояния.
2. Создайте класс снимка и опишите в нём все те же поля, которые имеются в оригинальном классе-создателе.
3. Сделайте объекты снимков неизменяемыми. Они должны получать начальные значения только один раз, через
   свой конструктор.
4. Если ваш язык программирования это позволяет, сделайте класс снимка вложенным в класс создателя. Если нет,
   извлеките из класса снимка пустой интерфейс, который будет доступен остальным объектам программы.
   Впоследствии вы можете добавить в этот интерфейс некоторые вспомогательные методы, дающие доступ к метаданным снимка,
   однако прямой доступ к данным создателя должен быть исключён.
5. Добавьте в класс создателя метод получения снимков. Создатель должен создавать новые объекты снимков,
   передавая значения своих полей через конструктор.
6. Сигнатура метода должна возвращать снимки через ограниченный интерфейс, если он у вас есть.
   Сам класс должен работать с конкретным классом снимка.
7. Добавьте в класс создателя метод восстановления из снимка. Что касается привязки к типам, руководствуйтесь той же
   логикой, что и в пункте 4.
8. Опекуны, будь то история операций, объекты команд или нечто иное, должны знать о том, когда запрашивать снимки
   у создателя, где их хранить и когда восстанавливать.
9. Связь опекунов с создателями можно перенести внутрь снимков. В этом случае каждый снимок будет привязан к своему
   создателю и должен будет сам восстанавливать его состояние. Но это будет работать либо если классы снимков вложены
   в классы создателей, либо если создатели имеют соответствующие сеттеры для установки значений своих полей.

Примеры использования:
Все реализации java.io.Serializable могут быть использованы как аналог Снимка.
Все реализации javax.faces.component.StateHolder.
 */
public class TestMemento {
    public static void main(String[] args) throws IllegalAccessException {
        MemEditor editor = new MemEditor();
        Circle blueCircle = new Circle(10, 10, 10, Color.BLUE);

        Circle yellowCircle = new Circle(blueCircle.getX(), blueCircle.getY(), blueCircle.getHeight(), blueCircle.getColor());

        yellowCircle.setColor(Color.DARK_GRAY);
        for (Field field : yellowCircle.getClass().getDeclaredFields()) {
            if (field.getName().equals("radius")) {
                field.setAccessible(true);
                field.set(yellowCircle, 25);
                field.setAccessible(false);
            }
        }
        yellowCircle.moveTo(50, 50);

        CompoundShape redCircleWithDotInCenter = new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
        );

        CompoundShape greenDottedRectangle = new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.GREEN),
                new Dot(360, 360, Color.GREEN),
                new Dot(360, 240, Color.GREEN)
        );

        editor.loadShapes(blueCircle, yellowCircle, redCircleWithDotInCenter, greenDottedRectangle);

        String plus = """
                1. Не нарушает инкапсуляции исходного объекта.
                2. Упрощает структуру исходного объекта. Ему не нужно хранить версий своего состояния.
                """;

        String minus = """
                1. Требует много памяти, если клиенты слишком часто создают снимки.
                2. Может повлечь дополнительные издержки памяти, если объекты, хранящие историю,
                   не освобождают ресурсы, занятые устаревшими снимками.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);

    }
}
