package ua.duikt.payments.method;

/**
 * Окремий вузький інтерфейс (принцип розділення інтерфейсів, ISP): можливість повернення коштів
 * є лише в тих способів оплати, які її підтримують. Без «порожніх» методів у інших.
 */
public interface Refundable {

    void refund(double amount);
}
