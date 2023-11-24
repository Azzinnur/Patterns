package behavioral_patterns.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//Платёжная стратегия с оплатой через PayPal
public class PayByPayPal implements PayStrategy{
    // Здесь должна быть БД с логинами, пока это заглушка в виде статической переменной.
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda@ya.com", "amanda1985");
        DATA_BASE.put("john@amazon.eu", "qwerty");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.printf("Платёж на сумму %s проведён с помощью PayPal.%n", paymentAmount);
            return true;
        }
        return false;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    //Собираем данные от клиента и верифицируем их.
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Введите ваш email: ");
                email = reader.readLine();
                System.out.print("Введите пароль: ");
                password = reader.readLine();
                if (verify()) {
                    System.out.println("Верификация прошла успешно.");
                } else {
                    System.out.println("Неверный email или пароль!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private boolean verify() {
        setSignedIn(DATA_BASE.containsKey(email) && password.equals(DATA_BASE.get(email)));
        return signedIn;
    }
}
