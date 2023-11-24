package behavioral_patterns.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//Платёжная стратегия с оплатой банковской картой
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;
    // Здесь должна быть БД с картами, пока это заглушка в виде статической переменной
    private static final Map<String, CreditCard> DATA_BASE = new HashMap<>();
    private boolean verified;

    static {
        DATA_BASE.put("12342523647584393233", new CreditCard("12342523647584393233", "01/25", "676"));
        DATA_BASE.put("12341234123412341234", new CreditCard("12341234123412341234", "04/24", "225"));
        DATA_BASE.put("00000000000000000000", new CreditCard("00000000000000000000", "00/00", "000"));
    }

    //Собираем данные платежной карты клиента и верифицируем их.
    @Override
    public void collectPaymentDetails() {
        try {
            while (!verified) {
                System.out.print("Введите номер карты: ");
                String number = reader.readLine();
                System.out.print("Введите срок действия карты: ");
                String date = reader.readLine();
                System.out.print("Введите ваш cvv: ");
                String cvv = reader.readLine();
                CreditCard newCard = new CreditCard(number, date, cvv);
                setCard(newCard);
                if (cardIsVerified(newCard)) {
                    System.out.println("Верификация карты прошла успешно.");
                } else {
                    System.out.println("Неверные данные карты!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (verified) {
            System.out.printf("Платёж на сумму %d проведён с помощью банковской карты.%n", paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsVerified(CreditCard card) {
        setVerified(DATA_BASE.containsKey(card.getNumber()) && card.equals(DATA_BASE.get(card.getNumber())));
        return verified;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
}
