package behavioral_patterns.strategy.strategies;

// Общий интерфейс всех платежных стратегий
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
