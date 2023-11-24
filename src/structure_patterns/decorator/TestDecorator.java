package structure_patterns.decorator;

import structure_patterns.decorator.decorators.CompressionDecorator;
import structure_patterns.decorator.decorators.DataSourceDecorator;
import structure_patterns.decorator.decorators.EncryptionDecorator;
/*
Тип паттерна: структурный.
Шаги реализации:
1. Убедитесь, что в вашей задаче есть один основной компонент и несколько
   опциональных дополнений или надстроек над ним.
2. Создайте интерфейс компонента, который описывал бы общие методы как для
   основного компонента, так и для его дополнений.
3. Создайте класс конкретного компонента и поместите в него основную бизнес-логику.
4. Создайте базовый класс декораторов. Он должен иметь поле для хранения ссылки на вложенный объект-компонент.
   Все методы базового декоратора должны делегировать действие вложенному объекту.
5. И конкретный компонент, и базовый декоратор должны следовать одному и тому же интерфейсу компонента.
6. Теперь создайте классы конкретных декораторов, наследуя их от базового декоратора. Конкретный декоратор
   должен выполнять свою добавочную функцию, а затем (или перед этим) вызывать эту же операцию обёрнутого объекта.
7. Клиент берёт на себя ответственность за конфигурацию и порядок обёртывания объектов.

Примеры:
java.util.Collections, методы checkedXXX(), synchronizedXXX() и unmodifiableXXX().
javax.servlet.http.HttpServletRequestWrapper и HttpServletResponseWrapper
Фильтры и интерсепторы в Spring.
 */
public class TestDecorator {
    public static void main(String[] args) {
        String salaryRecords = "   Name     Salary\nJohn Smith  100000\nSteven Jobs 912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("D:/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("D:/OutputDemo.txt");

        System.out.println("- Входные данные ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Закодированные и сжатые данные --------------");
        System.out.println(plain.readData());
        System.out.println("- Данные после распаковки и декодирования --------------");
        System.out.println(encoded.readData());
        System.out.println();

        String plus = """
                1. Большая гибкость, чем у наследования.
                2. Позволяет добавлять обязанности на лету
                3. Можно добавлять несколько обязанностей сразу несколькими обёртками.
                4. Позволяет иметь несколько мелких объектов вместо одного объекта на все случаи жизни.
                """;

        String minus = """
                1. Трудно конфигурировать многократно обёрнутые классы.
                2. Обилие крошечных классов.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
