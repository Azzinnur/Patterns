package creative_patterns.builder;

import creative_patterns.builder.builders.CarBuilder;
import creative_patterns.builder.builders.CarManualBuilder;
import creative_patterns.builder.builders.Director;
import creative_patterns.builder.entities.Car;
import creative_patterns.builder.entities.Manual;
/*
Тип паттерна: порождающий
Шаги создания:
1. Убедитесь в том, что создание разных представлений объекта можно свести к общим шагам.
2. Опишите эти шаги в общем интерфейсе строителей.
3. Для каждого из представлений объекта-продукта создайте по одному классу
   строителю и реализуйте их методы строительства.
4. Подумайте о создании класса директора. Его методы будут создавать различные
   конфигурации продуктов, вызывая разные шаги одного и того же строителя.
5. Клиентский код должен будет создавать и объекты строителей, и объект директора. Перед началом строительства
   клиент должен связать определённого строителя с директором. Это можно сделать либо через конструктор,
   либо через сеттер, либо подав строителя напрямую в строительный метод директора.
6. Результат строительства обычно возвращается из строителя, но можно вернуть и из директора,
   но только если метод возврата продукта удалось поместить в общий интерфейс строителей.
   Иначе вы жёстко привяжете директора к конкретным классам строителей.

Примеры
java.lang.StringBuilder#append() (unsynchronized)
java.lang.StringBuffer#append() (synchronized)
java.nio.ByteBuffer#put() (also in CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)
javax.swing.GroupLayout.Group#addComponent()
All implementations java.lang.Appendable
 */
public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();

        // Директор принимает в качестве аргумента конкретный билдер
        // от клиента (из приложения). Т.к. приложение само знает
        // какой билдер нужно использовать, чтобы получить нужный продукт.
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        // Финальный продукт часто получаются из билдера, так как директор
        // не зависит от конкретных билдеров и продуктов и не в курсе того,
        // какой продукт нам нужен.
        Car car = carBuilder.getResult();
        System.out.println("Car built: " + car.getCarType() + "\n");

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSUV(carManualBuilder);
        Manual carManual = carManualBuilder.getResult();
        System.out.println("Car manual built:\n" + carManual.print());

        String plus = """
                1. Позволяет создавать продукты пошагово.
                2. Позволяет использовать один и тот же код для создания различных продуктов
                3. Изолирует сложный код сборки продукта от его основной бизнес-логики.
                """;

        String minus = """
                1. Усложняет код программы из-за введения дополнительных классов.
                2. Клиент будет привязван к конкретным классам строителей, так как в интерфейсе директора
                   может не быть метода для получения результата.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
