package structure_patterns.flyweight;


import java.awt.*;
import java.util.Random;
/*
Тип паттерна: структурный.
Шаги реализации:
1. Разделить поля класса-кандидата в приспособленцы на 2 типа:
  - перманентные поля: поля содержащие неизменные данные, дублирующиеся во многих объектах;
  - переменные поля: поля содержащие неизменные данные, уникальные для каждого объекта.
2. Можно оставить перманентные поля в классе, но проверьте что они неизменны. Первоначальные значения им должны
   присваиваться только в конструкторе класса.
3. Для удобства лучше вынести весь набор постоянных полей в отдельный класс-приспособленец.
4. В методах класса-приспособленца, которые используют переменные поля, замените каждое такое поле параметром,
   и используйте этот параметр.
5. Создайте класс-фабрику для использования пула классов-приспособленцев. Он должен проверять, существует ли
   в пуле нужный класс перед тем как создать новый. Все запросы на получение класса-приспособленца должна
   получать фабрика, в которую передаются значения необходимых перманентных полей.

Примеры использования:
Пулы java.lang.Integer (also Boolean, Byte, Character, Short, Long and BigDecimal)
Пулы String
IoC контейнер BeanDefinitionов в Spring
 */
public class TestFlyweight {
    static final int CANVAS_SIZE = 1000;
    static final int TREES_TO_DRAW = 1000000;
    static final int TREE_TYPES = 4;

    public static void main(String[] args) {
        Forest forest = new Forest();
        Random random = new Random();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random.nextInt(0, CANVAS_SIZE), random.nextInt(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random.nextInt(0, CANVAS_SIZE), random.nextInt(0, CANVAS_SIZE),
                    "Orange Autumn Oak", Color.ORANGE, "Orange Autumn Oak texture stub");
            forest.plantTree(random.nextInt(0, CANVAS_SIZE), random.nextInt(0, CANVAS_SIZE),
                    "Yellow Autumn Oak", Color.YELLOW, "Yellow Autumn Oak texture stub");
            forest.plantTree(random.nextInt(0, CANVAS_SIZE), random.nextInt(0, CANVAS_SIZE),
                    "Red Autumn Oak", Color.RED, "Red Autumn Oak texture stub");
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.printf("Нарисовано %d деревьев %n", TREES_TO_DRAW);
        System.out.println("---------------------");
        System.out.println("Памяти использовано:");
        System.out.printf("Размер дерева (8 байт) * %d%n", TREES_TO_DRAW);
        System.out.printf("+ размер объекта TreeType (~30 байт) * %d%n", TREE_TYPES);
        System.out.println("---------------------");
        System.out.printf("Всего: %dMB вместо %dMB%n", ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024),
                ((TREES_TO_DRAW * 38) / 1024 / 1024));
        System.out.println();

        String plus = """
                1. Коллосальная экономия оперативной памяти и времени на создание новых объектов, если программа
                содержит множество одинаковых объектов.
                """;

        String minus = """
                1. Если переменные поля пересчитываются при вызове методов класса-легковеса, можно получить 
                   выигрыш по памяти, но потерять время работы процессора.
                2. Код становится более сложным, придётся постоянно защищать необходимость выделения
                   постоянных полей в отдельную сущность.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
