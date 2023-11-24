package behavioral_patterns.chain_of_responsibility;

import behavioral_patterns.chain_of_responsibility.middleware.Middleware;
import behavioral_patterns.chain_of_responsibility.middleware.RequestLimitMiddleware;
import behavioral_patterns.chain_of_responsibility.middleware.RoleCheckMiddleware;
import behavioral_patterns.chain_of_responsibility.middleware.UserExistsMiddleware;
import behavioral_patterns.chain_of_responsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Тип паттерна: поведенческий
Шаги реализации:
1. Создайте интерфейс обработчика и опишите в нём основной метод обработки. Продумайте, в каком виде клиент
   должен передавать данные запроса в обработчик. Самый гибкий способ — превратить данные запроса в объект
   и передавать его целиком через параметры метода обработчика. (в данном примере передаются 2 стринги)
2. Имеет смысл создать абстрактный базовый класс обработчиков, чтобы не дублировать реализацию метода получения
   следующего обработчика во всех конкретных обработчиках. (за это в примере отвечает метод link с хитрой реализацией:
   сначала идёт единичное поле, а затем массив). Добавьте в базовый обработчик поле для хранения ссылки \
   на следующий объект цепочки. Устанавливайте начальное значение этого поля через конструктор.
   Это сделает объекты обработчиков неизменяемыми. Но если программа предполагает динамическую перестройку цепочек,
   можете добавить и сеттер для поля. Реализуйте базовый метод обработки так, чтобы он перенаправлял запрос
   следующему объекту, проверив его наличие. Это позволит полностью скрыть поле-ссылку от подклассов, дав
   им возможность передавать запросы дальше по цепи, обращаясь к родительской реализации метода.
3. Один за другим создайте классы конкретных обработчиков и реализуйте в них методы обработки запросов.
   При получении запроса каждый обработчик должен решить:
   - Может ли он обработать запрос или нет?
   - Следует ли передать запрос следующему обработчику или нет?
4. Клиент может собирать цепочку обработчиков самостоятельно, опираясь на свою бизнес-логику, либо получать уже готовые
   цепочки извне. В последнем случае цепочки собираются фабричными объектами, опираясь на конфигурацию
   приложения или параметры окружения.
5. Клиент может посылать запросы любому обработчику в цепи, а не только первому. Запрос будет передаваться по цепочке
   до тех пор, пока какой-то обработчик не откажется передавать его дальше, либо когда будет достигнут конец цепи.
6. Клиент должен знать о динамической природе цепочки и быть готов к таким случаям:
   - Цепочка может состоять из единственного объекта.
   - Запросы могут не достигать конца цепи.
   - Запросы могут достигать конца, оставаясь необработанными.

Примеры:
java.util.logging.Logger#log()
javax.servlet.Filter#doFilter()
Цепочки фильтров в SpringSecurity, ServletContext и т.д.
 */
public class TestChainOfResponsibility {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");
        server.register("bitch@example.com", "bitch_pass");

        //Проверки связаны в цепь, можно строить различные цепи, используя одни и те эе компоненты.
        Middleware middleware = Middleware.link(
                new RequestLimitMiddleware(3),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // Сервер получает цепочку от клиентского кода.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.println("Введите логин (адрес электронной почты): ");
            String email = reader.readLine();
            System.out.println("Введите пароль: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
