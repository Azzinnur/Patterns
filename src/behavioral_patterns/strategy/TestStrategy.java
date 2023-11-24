package behavioral_patterns.strategy;

import behavioral_patterns.strategy.strategies.Order;
import behavioral_patterns.strategy.strategies.PayByCreditCard;
import behavioral_patterns.strategy.strategies.PayByPayPal;
import behavioral_patterns.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Тип паттерна: поведенческий.
Шаги реализации:
1. Определите алгоритм, который подвержен частым изменениям. Также подойдёт алгоритм, имеющий несколько вариаций,
   которые выбираются во время выполнения программы.
2. Создайте интерфейс стратегий, описывающий этот алгоритм. Он должен быть общим для всех вариантов алгоритма.
3. Поместите вариации алгоритма в собственные классы, которые реализуют этот интерфейс.
4. В классе контекста создайте поле для хранения ссылки на текущий объект-стратегию, а также метод для её изменения.
   Убедитесь в том, что контекст работает с этим объектом только через общий интерфейс стратегий.
5. Клиенты контекста должны подавать в него соответствующий объект-стратегию, когда хотят, чтобы контекст
   вёл себя определённым образом.

Примеры применения:
- java.util.Comparator#compare(), вызываемые из Collections#sort().
- javax.servlet.http.HttpServlet: метод service(), а также все методы doXXX() принимают объекты
  HttpServletRequest и HttpServletResponse в параметрах.
- javax.servlet.Filter#doFilter()
 */
public class TestStrategy {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;
            do {
                System.out.println("""
                                    Пожалуйста, выберите продукт:
                                    1 - Материская плата
                                    2 - Процессор
                                    3 - Жёсткий диск
                                    4 - Оперативная память""");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Количество: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Вы хотите продолжить выбор? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("""
                        Пожалуйста, выберите метод оплаты:
                        1 - PalPay
                        2 - Банковская карта""");
                String paymentMethod = reader.readLine();

                // Клиент создаёт различные стратегии на основании пользовательских данных, конфигурации
                // и прочих параметров.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
            // только стратегии знают какие данные им нужны для приёма оплаты.
            order.processOrder(strategy);

            System.out.printf("Сумма к оплате %d. Введите Y для оплаты N для продолжения заказа: ", order.getTotalCost());
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("y")) {
                // И наконец, стратегия запускает приём платежа.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Платёж проведён успешно.");
                } else {
                    System.out.println("Ошибка! Преверьте введенные данные.");
                }
                order.setClosed();
            }
        }
        System.out.println();

        String plus = """
                1. Горячая замена алгоритмов на лету.
                2. Изолирует код и данные алгоритмов от остальных классов.
                3. Уход от наследования к делегированию.
                4. Реализует принцип открытости/закрытости.
                """;

        String minus = """
                1. Усложняет код программы из-за доп. классов.
                2. Клиент должен знать, в чём состоит разница между стратегиями, чтобы выбрать подходящую.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}
