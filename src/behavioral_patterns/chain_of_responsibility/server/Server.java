package behavioral_patterns.chain_of_responsibility.server;

import behavioral_patterns.chain_of_responsibility.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

// Класс-обработчик цепи
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    //Клиент подаёт готовую цепочку в сервер. Это увеличивает гибкость и упрощает тестирование класса сервера.
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

     // Сервер получает email и пароль от клиента и запускает проверку авторизации у цепочки.
    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Аутентификация прошла успешна!");
            System.out.println();

            String plus = """
                    1. Уменьшает зависимость между клиентом и обработчиками.
                    2. Реализует принцип единственной обязанности.
                    3. Реализует принцип открытости/закрытости.
                    """;

            String minus = """
                1. Запрос может остаться никем не обработанным.
                """;

            System.out.println("Плюсы:\n" + plus);
            System.out.println("Минусы:\n" + minus);
            // Здесь должен быть какой-то полезный код, работающий для авторизированных пользователей.
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
