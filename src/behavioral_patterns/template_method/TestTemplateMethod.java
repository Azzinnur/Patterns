package behavioral_patterns.template_method;

import behavioral_patterns.template_method.networks.Facebook;
import behavioral_patterns.template_method.networks.SocialNetwork;
import behavioral_patterns.template_method.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Изучите алгоритм и подумайте, можно ли его разбить на шаги. Прикиньте, какие шаги будут стандартными для всех
   вариаций алгоритма, а какие — изменяющимися.
2. Создайте абстрактный базовый класс. Определите в нём шаблонный метод. Этот метод должен состоять из вызовов
   шагов алгоритма. Имеет смысл сделать шаблонный метод финальным, чтобы подклассы не могли переопределить его.
3. Добавьте в абстрактный класс методы для каждого из шагов алгоритма. Вы можете сделать эти методы абстрактными
   или добавить какую-то реализацию по умолчанию. В первом случае все подклассы должны будут реализовать эти методы,
   а во втором — только если реализация шага в подклассе отличается от стандартной версии.
4. Подумайте о введении в алгоритм хуков (это методы, которые не содержат никакого кода, выглядя как обычные методы.
   Шаблонный метод останется рабочим, даже если ни один подкласс не переопределит такой хук. Однако, хук даёт
   подклассам дополнительные точки «вклинивания» в шаблонный метод). Чаще всего, хуки располагают между основными
   шагами алгоритма, а также до и после всех шагов.
5. Создайте конкретные классы, унаследовав их от абстрактного класса. Реализуйте в них все недостающие шаги и хуки.

Примеры:
Все не-абстрактные методы классов java.io.InputStream, java.io.OutputStream, java.io.Reader и java.io.Writer.
Все не-абстрактные методы классов java.util.AbstractList, java.util.AbstractSet и java.util.AbstractMap.
javax.servlet.http.HttpServlet, все методы doXXX() по умолчанию возвращают HTTP-код 405 "Method Not Allowed".
Однако вы можете переопределить их при желании.
*/
public class TestTemplateMethod {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SocialNetwork network = null;
        System.out.print("Введите имя пользователя: ");
        String userName = reader.readLine();
        System.out.print("Введите пароль: ");
        String password = reader.readLine();
        System.out.print("Введите сообщение: ");
        String message = reader.readLine();

        System.out.println("""
                Выберите социальную сеть для публикации сообщения:
                1 - Facebook
                2 - Twitter""");
        int choice = Integer.parseInt(reader.readLine());

        // Создаем сетевые объекты и публикуем пост.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
        System.out.println();

        String plus = """
                1. Облегчает повторное использование кода.
                """;

        String minus = """
                1. Вы жёстко ограничены скелетом существующего алгоритма.
                2. С ростом количества шагов шаблонный метод становится слишком сложно поддерживать.
                3. Вы можете нарушить принцип подстановки Барбары Лисков, изменяя базовое поведение одного из шагов 
                   алгоритма через подкласс.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
