package behavioral_patterns.strategy.strategies;

import java.util.Map;
import java.util.Objects;

// Реализация кредитной карты
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard (String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(number, that.number) && Objects.equals(date, that.date) && Objects.equals(cvv, that.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, cvv);
    }
}
