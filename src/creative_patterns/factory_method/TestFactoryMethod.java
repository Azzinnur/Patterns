package creative_patterns.factory_method;

import creative_patterns.factory_method.factories.LinuxOSFactory;
import creative_patterns.factory_method.factories.OSFactory;
/*
Тип паттерна: порождающий.
Шаги создания:
1. Приведите все создаваемые продукты к общему интерфейсу
2. В классе, который производит продукты, создайте пустой фабричный метод.
   В качестве возвращаемого типа укажите общий интерфейс продукта.
3. Найдите все участки кода класса, создающие продукты. Поочерёдно замените эти
   участки вызовами фабричного метода, перенося в него код создания различных
   продуктов.
4. В фабричный метод, возможно, придётся добавить несколько параметров,
   контролирующих, какой из продуктов нужно создать.
   На этом этапе фабричный метод, скорее всего, будет выглядеть удручающе. В нём будет жить большой условный
   оператор, выбирающий класс создаваемого продукта. Это можно исправить.
5. Для каждого типа продуктов заведите подкласс и переопределите в нём
   фабричный метод. Переместите туда код создания соответствующего продукта из
   суперкласса.
6. Если создаваемых продуктов слишком много для существующих подклассов
   создателя, вы можете подумать о введении параметров в фабричный метод,
   которые позволят возвращать различные продукты в пределах одного подкласса.
7  Если после всех перемещений фабричный метод стал пустым, можете сделать его
   абстрактным. Если в нём что-то осталось — не беда, это будет его реализацией по
   умолчанию.

Примеры паттерна:
java.util.Calendar#getInstance()
java.util.ResourceBundle#getBundle()
java.text.NumberFormat#getInstance()
java.nio.charset.Charset#forName()
java.net.URLStreamHandlerFactory#createURLStreamHandler(String)
java.util.EnumSet#of()
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        String system = "WinDOws";
        OperationalSystem operationalSystem = OSFactory.selectOperationSystem(system);
        operationalSystem.getOs();

        OSFactory osFactory = new LinuxOSFactory();
        osFactory.determineOs().getOs();
        System.out.println();

        String plus = """
                1. Избавляет клиенский код от привязки к конкретным классам продуктов.
                2. Выделяет код производства продуктов в одно место, упрощая подержку кода
                3. Упрощает добавление новых продуктов в программу.
                4. Реализует принцип открытости/закрытости.
                """;

        String minus = """
                1. Может привести к созданию большиз параллельных иерархий классов, т.к. для каждого продукта нужен
                   свой подкласс создателя.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
