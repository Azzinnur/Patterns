package structure_patterns.adapter;

import structure_patterns.adapter.java_entity_to_database.Database;
import structure_patterns.adapter.java_entity_to_database.EntityToDatabaseAdapter;
import structure_patterns.adapter.pegs_and_holes.RoundHole;
import structure_patterns.adapter.pegs_and_holes.RoundPeg;
import structure_patterns.adapter.pegs_and_holes.SquarePeg;
import structure_patterns.adapter.pegs_and_holes.SquarePegAdapter;
/*
Вид паттерна: структурный.
Шаги реализации:
1. Убедитесь, что у вас есть два класса с несовместимыми интерфейсами:
   - полезный сервис — служебный класс, который вы не можете изменять (он либо стороннийб либо неизменяемый)
   - один или несколько клиентов — существующих классов приложения, несовместимых с сервисом
     из-за неудобного или несовпадающего интерфейса.
2. Опишите клиентский интерфейс, через который классы приложения смогли бы
   использовать класс сервиса.
3. Создайте класс адаптера, реализовав этот интерфейс.
4. Поместите в адаптер поле, которое будет хранить ссылку на объект сервиса. Обычно это поле заполняют объектом,
   переданным в конструктор адаптера. В случае простой адаптации этот объект можно передавать через параметры
   методов адаптера.
5. Реализуйте все методы клиентского интерфейса в адаптере. Адаптер должен делегировать основную работу сервису!
6. Приложение должно использовать адаптер только через клиентский интерфейс.
   Это позволит легко изменять и добавлять адаптеры в будущем

Примеры:
java.util.Arrays#asList()
java.util.Collections#list()
java.util.Collections#enumeration()
java.io.InputStreamReader(InputStream) (возвращает Reader)
java.io.OutputStreamWriter(OutputStream) (возвращает Writer)
 */
public class TestAdapter {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg squarePeg1 = new SquarePeg(3.5);
        SquarePeg squarePeg2 = new SquarePeg(5);

        //Вариант реализации через конструктор
        SquarePegAdapter smallerPegAdapter = new SquarePegAdapter(squarePeg1);
        SquarePegAdapter largerPegAdapter = new SquarePegAdapter(squarePeg2);

        if (hole.fits(smallerPegAdapter)) {
            System.out.println("Square peg w3.5 fits round hole r5.");
        } else {System.out.println("Square peg w3.5 does not fit round hole r5.");}
        if (hole.fits(largerPegAdapter)) {
            System.out.println("Square peg w5 fits round hole r5.");
        } else {System.out.println("Square peg w5 does not fit round hole r5.");}

        System.out.println("================================");

        // Вариант реализации через интерфейс
        Database database = new EntityToDatabaseAdapter();

        database.insert();
        database.select();
        database.update();
        database.delete();
        System.out.println();

        String plus = """
                1. Отделяет и скрывает от клиента подробности преобразования различных интерфейсов.
                """;

        String minus = """
                1. Усложняет программу введением дополнительного класса.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
